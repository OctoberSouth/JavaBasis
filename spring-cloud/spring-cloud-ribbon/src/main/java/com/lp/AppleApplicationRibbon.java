package com.lp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 生产者服务
 *
 * @author 刘攀
 * @version 1.0
 * @time 2019年11月8日下午2:47:53
 * @describe
 */
@EnableEurekaClient
@SpringBootApplication
public class AppleApplicationRibbon implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppleApplicationRibbon.class, args);
    }

    @Override
    public void run(String... strings) {
        System.out.println("服务消费者Ribbon启动完毕.");
    }
}
