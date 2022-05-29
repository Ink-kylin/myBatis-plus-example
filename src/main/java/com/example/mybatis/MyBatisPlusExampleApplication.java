package com.example.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;

import java.io.IOException;

/**
 * @author albert
 */
@SpringBootApplication
@ConfigurationPropertiesScan
@MapperScan(value = "com.example.mybatis.mapper")
public class MyBatisPlusExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusExampleApplication.class, args);
    }

}
