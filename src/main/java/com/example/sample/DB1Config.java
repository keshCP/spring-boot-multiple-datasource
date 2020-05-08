package com.example.sample;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DB1Config {

	//DB1 is primary data source and it use jdbc template.if you want to use this data source as jpa(Ex:Query methods (findById(String id)))  so you should make this class as DB2Config
	
	@Primary
	@Bean(name = "dsDB1")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSourceMarksys() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "DB1")
	public JdbcTemplate jdbcTemplateMarksys(@Qualifier("dsDB1") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
}
