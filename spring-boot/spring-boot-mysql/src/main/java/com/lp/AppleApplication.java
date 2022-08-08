package com.lp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * springboot 启动
 */
@SpringBootApplication
/**
 * 扫描包
 */
@MapperScan("com.lp")
/**
 * 事务
 */
@EnableTransactionManagement
/**
 * 启动
 * @author 刘攀
 * @version 1.0
 * @date 2019/12/5 21:15
 * @return
 * @describe
 */
public class AppleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppleApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        System.out.println("服务启动完毕.");
    }
}
