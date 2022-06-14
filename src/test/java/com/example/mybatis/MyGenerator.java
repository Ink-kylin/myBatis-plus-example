package com.example.mybatis;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.mybatis.enums.AgeEnum;
import com.example.mybatis.properties.MyDatasourceProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.shaded.org.apache.commons.lang.text.StrBuilder;

import java.util.Collections;

/**
 * @author kylin
 */
@SpringBootTest
@EnableConfigurationProperties(MyDatasourceProperties.class)
public class MyGenerator {

    @Autowired
    private MyDatasourceProperties properties;

    @Test
    void printInfo(){
        System.out.println("测试自动化构建");

    }

    @Test
    void context(){
        String url = properties.getUrl();
        String username = properties.getUsername();
        String password = properties.getPassword();
        FastAutoGenerator.create(url,username,password)
                .globalConfig(builder -> {
                    builder.author("Inkylin") // 设置作者
                            .enableSwagger()
                            .outputDir("/home/albert/coding/java/MyBatis-Plus-Example/src/main/java")
                            .dateType(DateType.TIME_PACK)
                            .commentDate("yyyy-MM-dd");
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.mybatis")
                            .pathInfo(Collections.singletonMap(OutputFile.xml,"/home/albert/coding/java/MyBatis-Plus-Example/src/main/resources/mapper"));
                })
/*                .templateConfig(builder -> {
                    // 设置父包名
                    builder.entity("/mapper/entity.java")
                            .service("/mapper/service.java")
                            .serviceImpl("/mapper/serviceImpl.java")
                            .mapper("/mapper/mapper.java")
                            .xml("/mapper/mapper.xml")
                            .controller("/mapper/controller.java")
                            .build();
                })*/
                .strategyConfig(builder -> builder
                        .addInclude("user_info")
                        //实体策略配置
                        .entityBuilder()
                        //.logicDeletePropertyName("isDeleted")
                        //启用lombok
                        .enableLombok()
                        //开启生成实体时生成字段注解
                        //.enableTableFieldAnnotation()
                        //开启 ActiveRecord 模型
                        //.enableActiveRecord()
                        //字段常量
                        //.enableColumnConstant()
                        //开启链式模型
                        .enableChainModel()
                        .build()
                        //controller策略
                        .controllerBuilder()
                        //开启生成@RestController 控制器
                        .enableRestStyle()
                        .build()
                        //service配置
                        .serviceBuilder()
                        .build()
                        //mapper配置
                        .mapperBuilder()
                        //开启@Mapper注解
                        //.enableMapperAnnotation()
                        .enableBaseResultMap()
                        .enableBaseColumnList()
                        .build())

                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }


}
