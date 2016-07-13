package edu.showcase.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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
}
