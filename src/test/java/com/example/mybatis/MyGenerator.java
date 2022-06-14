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

import java.util.ArrayList;
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
        ArrayList<String> includeList = new ArrayList<>();
        includeList.add("my_focus");
        //includeList.add("content_manage");
        includeList.add("party_build_leader_question");
        includeList.add("project_construction_management");
        includeList.add("supervise_official_document");
        includeList.add("target");
        FastAutoGenerator.create(url,username,password)
                .globalConfig(builder -> {
                    builder.author("Inkylin") // 设置作者
                            .enableSwagger()
                            .outputDir("/home/albert/coding/company/wzfgdn/uqian-cloud-base/uqian-cloud-base-web/src/main/java")
                            .dateType(DateType.TIME_PACK)
                            .commentDate("yyyy-MM-dd");
                })
                .packageConfig(builder -> {
                    builder.parent("com.uqian.framework.base.workbench")
                            .entity("po")
                            .pathInfo(Collections.singletonMap(OutputFile.xml,"/home/albert/coding/company/wzfgdn/uqian-cloud-base/uqian-cloud-base-web/src/main/resources/META-INF/mapper/mysql/workbench"));
                })
                .strategyConfig(builder -> builder
                        .addInclude(includeList)
                        //实体策略配置
                        .entityBuilder()
                        .logicDeletePropertyName("isDeleted")
                        //启用lombok
                        .enableLombok()
                        //开启链式模型
                        .enableChainModel()
                        .build()
                        .controllerBuilder()
                        .enableRestStyle()
                        .build()
                        .serviceBuilder()
                        .build()
                        .mapperBuilder()
                        .enableBaseResultMap()
                        .enableBaseColumnList()
                        .build())

                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }


}
