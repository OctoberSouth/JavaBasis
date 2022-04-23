package com.lp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 生产者服务
 *
 * @author 刘攀
 * @version 1.0
 * @time 2019年11月8日下午2:47:53
 * @describe
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewaySentinelApplicationClient implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GatewaySentinelApplicationClient.class, args);
    }

    @Override
    public void run(String... strings) {
        System.out.println("gateway-sentinel服务生产者启动完毕.");
    }
}
