package com.lp.entity;

import lombok.Data;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2019/12/6 10:36
 * @describe
 */
@Data
public class User extends BaseEntity {

    /**
     * 用戶名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
}
