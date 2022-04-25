package com.lp.exception;

import com.lp.common.ResultJson;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.util.validation.ValidationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 刘攀
 */
@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobalException {
    /**
     * 业务异常统一处理
     * 用于处理由业务代码抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    public ResultJson handleBizException(BizException e) {
        String msg = e.getMsg();
        log.error("捕获到全局业务异常: {}", msg);
        return new ResultJson(e.getCode(), msg, e.getData());
    }

    /**
     * 全局未预期异常捕获
     * 用于处理非业务代码抛出,系统没有处理的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultJson handleBizException(Exception e) {
        log.error("捕获到全局未预期异常 :", e);
        return new ResultJson(ExceptionEnum.UNKNOW.getCode(), e.getCause().getCause().getMessage());
    }

    /**
     * 参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ValidationException.class)
    public ResultJson validationExceptionException(ValidationException e) {
        String msg = e.getMessage().split(":")[1].strip();
        log.error("捕获到参数绑定异常:{}", msg);
        return new ResultJson(ExceptionEnum.PARAMETER.getCode(), msg);
    }

    /**
     * 参数绑定异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public ResultJson bindException(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        Set<String> msgSet = fieldErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toSet());
        String msg = StringUtils.collectionToCommaDelimitedString(msgSet);
        log.error("捕获到参数绑定异常: {}", msg);
        return new ResultJson(ExceptionEnum.PARAMETER.getCode(), msg);
    }

    /**
     * 文件异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MultipartException.class)
    public ResultJson handleMultipartException(MultipartException e) {
        log.error("文件异常: 文件大小限制为10M");
        return new ResultJson(ExceptionEnum.UNKNOW.getCode(), "文件大小限制为10M");
    }

}