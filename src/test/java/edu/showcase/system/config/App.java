package edu.showcase.system.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.getEnvironment().setActiveProfiles("real");
		context.register(AppConfig.class);
		context.refresh();
		
		context.close();
		
	}
}
