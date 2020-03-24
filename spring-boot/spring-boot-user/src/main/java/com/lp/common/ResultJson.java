package com.lp.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 刘攀
 * @date 2019/12/6 10:46
 * @return
 * @version 1.0
 * @describe 统一返回JSON数据
 */
@Data
@ApiModel(value = "接口统一返回类")
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

	/**
	 * 结果
	 */
	@ApiModelProperty(value = "状态码")
	private Integer statusCode = SUCCESS;

	/**
	 * 消息
	 */
	@ApiModelProperty(value = "消息内容")
	private String message = "";

	/**
	 * 数据
	 */
	@ApiModelProperty(value = "返回数据")
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
