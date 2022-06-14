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


	@Test
	void format(){
		String s = AgeEnum.ONE.name();
		System.out.println(s);

	}

	/**
	* @author albert
	* @Description 温州调度台
	* @Date 2022/6/14
	* @Param
	* @return void
	**/
	@Test
	void wz_dispatch(){
		String url = properties.getUrl();
		String username = properties.getUsername();
		String password = properties.getPassword();
		FastAutoGenerator.create(url, username,password)
				.globalConfig(builder -> {
					builder.author("albert")
							.enableSwagger()
							.outputDir("/home/albert/coding/company/wzfgdn/uqian-cloud-base/uqian-cloud-base-web/src/main/java")
							.dateType(DateType.TIME_PACK)
							.commentDate("yyyy-MM-dd");
				})
				.packageConfig(builder -> {
					builder.parent("com.uqian.framework.base.dispatch")
							.entity("data")
							.pathInfo(Collections.singletonMap(OutputFile.xml,"/home/albert/coding/company/wzfgdn/uqian-cloud-base/uqian-cloud-base-web/src/main/resources/META-INF/mapper/mysql/dispatch"));
				})
				.strategyConfig(builder -> builder
						.addInclude("key_target","business_menu","party_build_leader_question","work_joint","highlight_work","key_work")
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
