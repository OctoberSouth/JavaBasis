package com.lp.vo;

import lombok.Data;

/**
 * @author 刘攀
 * @version 1.0
 * @date 2019/12/6 10:46
 * @return
 * @describe 统一返回JSON数据
 */
@Data
public class ResultVO<T> {
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
    private T data;

    public ResultVO() {
        super();
    }

    public ResultVO(Integer statusCode, String message) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResultVO(Integer statusCode, String message, T data) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public ResultVO(T data) {
        super();
        this.data = data;
    }
}
