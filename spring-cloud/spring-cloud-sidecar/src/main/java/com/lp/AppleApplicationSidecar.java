package com.lp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * 整合其他服务
 * 
 * @author 刘攀
 * @time 2019年11月8日下午2:47:53
 * @version 1.0
 * @describe
 */
@EnableSidecar
@SpringBootApplication
public class AppleApplicationSidecar implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppleApplicationSidecar.class, args);
	}

	@Override
	public void run(String... strings) {
		System.out.println("整合其他服务启动完毕.");
	}
}
