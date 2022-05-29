package com.example.mybatis.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource.druid")
@Data
public class MyDatasourceProperties {

	private String url;

	private String  username;

	private String password;


}
