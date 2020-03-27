package com.lp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务网关Gateway
 * 
 * @author 刘攀
 * @time 2019年11月8日下午2:47:53
 * @version 1.0
 * @describe
 */
@SpringBootApplication
@EnableEurekaClient
public class AppleApplicationGateway implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppleApplicationGateway.class, args);
	}

	@Override
	public void run(String... strings) {
		System.out.println("服务网关Gateway启动完毕.");
	}
}
