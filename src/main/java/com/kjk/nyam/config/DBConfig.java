package com.kjk.nyam.config;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kjk.nyam.mapper")
public class DBConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}
}

