package com.lp;

import com.lp.mq.MyProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * 消息中间组件
 *
 * @author 刘攀
 * @version 1.0
 * @time 2019年11月8日下午2:47:53
 * @describe
 */
@EnableEurekaClient
@SpringBootApplication
@EnableBinding(value = {MyProcessor.class})
public class AppleApplicationStreamClient implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppleApplicationStreamClient.class, args);
    }

    @Override
    public void run(String... strings) {
        System.out.println("消息中间组件消费者启动完毕.");
    }
}
