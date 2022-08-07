package com.lp.common;

import lombok.Data;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2019年2月18日下午5:59:28
 * @describe 统一返回JSON数据
 */
@Data
public class ResultJson {
    /**
     * 正确返回
     */
    public static final Integer SUCCESS = 200;
    /**
     * 参数不正确
     */
    public static final Integer FAILURE = 412;
    /**
     * 程序内部错误
     */
    public static final Integer ERROR = 500;
    /** 用户模块end**/

    /**
     * 结果
     */
    private Integer statusCode = SUCCESS;

    /**
     * 消息
     */
    private String message = "";

    /**
     * 数据
     */
    private Object data;

    public ResultJson() {
        super();
    }

    public ResultJson(Integer statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResultJson(Integer statusCode, String message, Object data) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public ResultJson(Object data) {
        super();
        this.data = data;
    }
}
