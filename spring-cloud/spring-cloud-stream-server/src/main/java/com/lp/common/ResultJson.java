package com.lp.common;

import lombok.Data;
import lombok.Getter;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2019年2月18日下午5:59:28
 * @describe 统一返回JSON数据
 */
@Data
public class ResultJson {

    /**
     * 结果
     */
    private Integer statusCode = StatusCodeEnum.SUCCESS.getCode();
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    public ResultJson() {
        super();
    }

    public ResultJson(StatusCodeEnum statusCodeEnum, String message) {
        super();
        this.statusCode = statusCodeEnum.getCode();
        this.message = message;
    }

    public ResultJson(StatusCodeEnum statusCodeEnum, String message, Object data) {
        super();
        this.statusCode = statusCodeEnum.getCode();
        this.message = message;
        this.data = data;
    }

    public ResultJson(Object data) {
        super();
        this.data = data;
    }

    public static ResultJson success(Object data) {
        return new ResultJson(data);
    }

    public static ResultJson error(String message) {
        return new ResultJson(StatusCodeEnum.ERROR, message);
    }

    /**
     * @Author 刘攀
     * @Date 2020/3/25 18:17
     * @Version 1.0
     * @Description 返回statusCode 统一限定
     **/
    public enum StatusCodeEnum {
        /**
         * 返回statusCode 统一限定
         */
        SUCCESS(200, "正确返回"),
        FAILURE(412, "参数不正确"),
        ERROR(500, "程序内部错误");
        /**
         * 标识码
         */
        @Getter
        private Integer code;

        /**
         * 信息
         */
        private String msg;

        StatusCodeEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }
}
