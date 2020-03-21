package com.lp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 服务网关
 * 
 * @author 刘攀
 * @time 2019年11月8日下午2:47:53
 * @version 1.0
 * @describe
 */
@EnableZuulProxy
@SpringBootApplication
public class AppleApplicationZuul implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppleApplicationZuul.class, args);
	}

	@Override
	public void run(String... strings) {
		System.out.println("服务网关启动完毕.");
	}
}
