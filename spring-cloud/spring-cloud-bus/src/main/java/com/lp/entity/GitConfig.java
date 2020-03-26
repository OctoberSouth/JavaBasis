package com.lp.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author 刘攀
 * @Date 2020/3/26 16:13
 * @Version 1.0
 * @Deacription 这种获取配置不会自动刷新
 **/
@Data
@Component
public class GitConfig {

    @Value("${data.env}")
    private String env;

    @Value("${data.user.username}")
    private String username;

    @Value("${data.user.password}")
    private String password;
}
