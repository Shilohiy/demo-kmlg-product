package com.hqyj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hqyj.dao")
@MapperScan("com.hqyj.mapper")
public class MyApp {

    public static void main(String[] args) {

        //启动方法
        SpringApplication.run(MyApp.class,args);
    }
}
