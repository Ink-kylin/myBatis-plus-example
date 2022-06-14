package com.example.mybatis;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.mybatis.config.YqComapnyProperties;
import com.example.mybatis.enums.AgeEnum;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.shaded.org.apache.commons.lang.text.StrBuilder;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@SpringBootTest
public class CompanyGenerator {

	@Autowired
	private YqComapnyProperties properties;


	/*
	* count must be an integer: strconv.Atoi: parsing "-p": invalid syntax

	 * */
/*	@Test
	void format(){
		String s = AgeEnum.ONE.name();
		System.out.println(s);

	}

	@Test
	void workbench(){
		String url = properties.getUrl();
		String username = properties.getUsername();
		String password = properties.getPassword();
		FastAutoGenerator.create(url, username,password)
				.globalConfig(builder -> {
					builder.author("albert") // 设置作者
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
					builder.parent("com.uqian.framework.base.workbench")
							.pathInfo(Collections.singletonMap(OutputFile.xml,"/home/albert/coding/company/wzfgdn/uqian-cloud-base/uqian-cloud-base-web/src/main/resources/META-INF/mapper/mysql/workbench"));
				})
				.strategyConfig(builder -> builder
						.addInclude("highlight_work")
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
	}*/


}
