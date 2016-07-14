package edu.showcase.system.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class AppConfig {

	@Bean
    @Profile("dev")
	public String getDataDev() {
		
		String database ="mysql";
		
		return database;
	}
	
	@Bean
    @Profile("real")
	public String getDataReal() {
		
		String database ="oracle";
		
		return database;
	}
	
	@Bean 
	String getData1(DataSource dataSource) {
		return "getData";
	}

	@Bean
	@Primary
	public DataSource dataSource1() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
	}
	
	@Bean
	public DataSource dataSource2() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
	}

}
