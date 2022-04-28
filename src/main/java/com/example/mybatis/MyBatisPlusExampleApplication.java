package com.example.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author albert
 */
@SpringBootApplication
@MapperScan(value = "com.example.mybatis.mapper")
public class MyBatisPlusExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusExampleApplication.class, args);
    }

}