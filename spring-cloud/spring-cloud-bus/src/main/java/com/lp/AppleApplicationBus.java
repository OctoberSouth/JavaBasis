package com.lp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * BUS
 *
 * @author 刘攀
 * @version 1.0
 * @time 2019年11月8日下午2:47:53
 * @describe
 */
@EnableEurekaClient
@SpringBootApplication
public class AppleApplicationBus implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppleApplicationBus.class, args);
    }

    @Override
    public void run(String... strings) {
        System.out.println("消息BUS启动完毕.");
    }
}
