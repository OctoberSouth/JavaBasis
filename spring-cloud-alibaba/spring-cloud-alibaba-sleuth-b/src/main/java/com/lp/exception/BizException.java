package com.lp.exception;

import lombok.Data;

/**
 * @author 刘攀
 */
@Data
public class BizException extends RuntimeException {

    private String msg;
    private Integer code;
    private Object data;

    public BizException(String msg) {
        super(msg);
        this.code = ExceptionEnum.FAIL.getCode();
        this.msg = msg;
    }

    public BizException(String msg, Throwable e) {
        super(msg, e);
        this.code = ExceptionEnum.FAIL.getCode();
        this.msg = msg;
    }

    public BizException(String msg, Integer code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public BizException(String msg, ExceptionEnum exceptionEnum) {
        super(msg);
        this.code = exceptionEnum.getCode();
        this.msg = msg;
    }

    public BizException(ExceptionEnum exceptionEnum, Object data) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMessage();
        this.data = data;
    }

    public BizException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMessage();
    }
}