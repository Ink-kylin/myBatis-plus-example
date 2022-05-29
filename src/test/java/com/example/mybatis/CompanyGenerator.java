package com.example.mybatis;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.mybatis.config.YqComapnyProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.shaded.org.apache.commons.lang.text.StrBuilder;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class CompanyGenerator {

	@Autowired
	private YqComapnyProperties properties;


	/*
	* count must be an integer: strconv.Atoi: parsing "-p": invalid syntax

	 * */
	@Test
	void format(){
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter yearMonth = DateTimeFormatter.ofPattern("yyyyMM");
		DateTimeFormatter minutesSeconds = DateTimeFormatter.ofPattern("HHmmss");
		StrBuilder objectName = new StrBuilder();
		StrBuilder append = objectName.append(now.format(yearMonth))
				.append(File.separatorChar)
				.append(now.format(minutesSeconds))
				.append("file.docx");
		System.out.println(append);
	}

	//http://ydyl-oss.oss-cn-hangzhou-zwynet-d01-a.internet.cloud.zj.gov.cn/ydtllocal/1a2c2eb5-fb3d-4403-9567-2be23dc02aab.xlsx?OSSAccessKeyId=QJOYtCXjHyvnl3Ev&Expires=1653582468&Signature=oTlhWaEyQvKMn0Gm0nZZF%2FPf048%3D
	@Test
	void context(){
		String url = properties.getUrl();
		String username = properties.getUsername();
		String password = properties.getPassword();
		FastAutoGenerator.create(url, username,password)
				.globalConfig(builder -> {
					builder.author("inkylin") // 设置作者
							// 开启 swagger 模式
							.enableSwagger()
							// 指定输出目录
							.outputDir("/home/albert/coding/company/uqian-beltroad/uqian-beltroad-investment/src/main/java")
							//时间策略
							.dateType(DateType.TIME_PACK)
							//注释日期
							.commentDate("yyyy-MM-dd");
				})
				.packageConfig(builder -> {
					// 设置父包名
					builder.parent("com.uqian.beltroad.investment.joint");
					// 设置mapperXml生成路径
				})
				.strategyConfig(builder -> builder
						.addInclude("work_joint_file")
						//实体策略配置
						.entityBuilder()
						//.logicDeletePropertyName("isDeleted")
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
