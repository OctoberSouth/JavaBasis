package com.lp.exception;

/**
 * @author 刘攀
 */
public enum ExceptionEnum {
    /**
     * 状态枚举
     */
    SUCCESS(2000, "操作成功"),
    NOLOGIN(4011, "未登录"),
    FAIL(5000, "操作失败"),
    PARAMETER(5001, "参数错误"),
    UNKNOW(5500, "未预期的错误");

    /**
     * 定义枚举属性
     */
    private final Integer code;
    private final String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
