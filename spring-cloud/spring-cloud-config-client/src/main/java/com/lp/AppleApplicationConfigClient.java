package com.lp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * config配置client
 * 
 * @author 刘攀
 * @time 2019年11月8日下午2:47:53
 * @version 1.0
 * @describe
 */
@EnableEurekaClient
@SpringBootApplication
public class AppleApplicationConfigClient implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppleApplicationConfigClient.class, args);
	}

	@Override
	public void run(String... strings) {
		System.out.println("config配置client启动完毕.");
	}
}
