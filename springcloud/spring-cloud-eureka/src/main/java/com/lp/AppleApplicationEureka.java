package com.lp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册服务
 * 
 * @author 刘攀
 * @time 2019年11月8日下午2:47:53
 * @version 1.0
 * @describe
 */
@EnableEurekaServer
@SpringBootApplication
public class AppleApplicationEureka implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppleApplicationEureka.class, args);
	}

	@Override
	public void run(String... strings) {
		System.out.println("服务者启动完毕.");
	}
}
