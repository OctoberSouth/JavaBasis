package com.lp.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户返回实体类
 *
 * @author 刘攀
 */
@ApiModel(value = "用户返回实体类")
@Data
public class UserVO {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;
}
