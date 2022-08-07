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
 * FeignHystrix
 *
 * @author 刘攀
 * @time 2019年11月8日下午2:47:53
 * @version 1.0
 * @describe
 */
@EnableEurekaClient
@SpringBootApplication
public class AppleApplicationFeignHystrix implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppleApplicationFeignHystrix.class, args);
    }

    @Override
    public void run(String... strings) {
        System.out.println("服务消费者FeignHystrix启动完毕.");
    }
}
