package com.lp.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author 刘攀
 * @Date 2020/3/26 16:14
 * @Version 1.0
 * @Deacription 这种获取配置会自动刷新
 **/
@Component
@Data
@ConfigurationProperties(prefix = "data")
public class GitAutoRefreshConfig {

    private String env;
    private UserInfo user;

    @Data
    public static class UserInfo {
        private String username;

        private String password;

        @Override
        public String toString() {
            return "UserInfo{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
