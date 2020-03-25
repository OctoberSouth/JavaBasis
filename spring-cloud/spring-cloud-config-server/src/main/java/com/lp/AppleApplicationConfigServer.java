package com.lp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * config server
 * 
 * @author 刘攀
 * @time 2019年11月8日下午2:47:53
 * @version 1.0
 * @describe
 */
@EnableConfigServer
@SpringBootApplication
public class AppleApplicationConfigServer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppleApplicationConfigServer.class, args);
	}

	@Override
	public void run(String... strings) {
		System.out.println("config server启动完毕.");
	}
}
