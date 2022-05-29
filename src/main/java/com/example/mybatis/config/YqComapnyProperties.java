package com.example.mybatis.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "uqian")
@Data
@ToString
public class YqComapnyProperties {

	private String url;

	private String username;

	private String password;


}
