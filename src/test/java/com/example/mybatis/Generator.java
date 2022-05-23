package com.example.mybatis;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kylin
 */
@SpringBootTest
public class Generator {

    private static final  String USERNAME = "hzcx";

    private static final  String PASSWORD = "hzyb@2021!@#";

    private  String url = "jdbc:mysql://121.41.1.145:33065/wzfgdn?characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2b8";


    @Test
    void context(){
        FastAutoGenerator.create(url,USERNAME,PASSWORD)
                .globalConfig(builder -> {
                    builder.author("kylin") // 设置作者
                            // 开启 swagger 模式
                            .enableSwagger()
                            // 指定输出目录
                            .outputDir("/home/albert/coding/company/wzfgdn/uqian-cloud-base/uqian-cloud-base-web/src/main/java")
                            //时间策略
                            .dateType(DateType.TIME_PACK)
                            //注释日期
                            .commentDate("yyyy-MM-dd");
                })
                .packageConfig(builder -> {
                    // 设置父包名
                    builder.parent("com.uqian.framework.base.workbench");
                    // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> builder
                        .addInclude("content_manage")
                        //实体策略配置
                        .entityBuilder()
                        .logicDeletePropertyName("isDeleted")
                        //启用lombok
                        .enableLombok()
                        //开启生成实体时生成字段注解
                        //.enableTableFieldAnnotation()
                        //开启链式模型
                        .enableChainModel()
                        //controller策略
                        .controllerBuilder()
                        //开启生成@RestController 控制器
                        .enableRestStyle()
                        //service配置
                        .serviceBuilder()
                        //mapper配置
                        .mapperBuilder()
                        .enableMapperAnnotation()
                        .enableBaseResultMap()
                        .enableBaseColumnList()
                        .build())
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
