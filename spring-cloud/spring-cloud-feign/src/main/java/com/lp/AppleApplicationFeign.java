package com.lp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 表明是feign
 */
@EnableFeignClients
/**
 * 生产者服务
 *
 * @author 刘攀
 * @time 2019年11月8日下午2:47:53
 * @version 1.0
 * @describe
 */
@EnableEurekaClient
@SpringBootApplication
public class AppleApplicationFeign implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppleApplicationFeign.class, args);
    }

    @Override
    public void run(String... strings) {
        System.out.println("服务消费者Feign启动完毕.");
    }
}
