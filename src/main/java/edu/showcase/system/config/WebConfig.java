package edu.showcase.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//<context:component-scan base-package="edu.showcase.business" use-default-filters="false">
//<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
//</context:component-scan>

@Configuration
@ComponentScan(
		basePackages="edu.showcase.business",
		useDefaultFilters=false,
		includeFilters={
				        @ComponentScan.Filter(type=FilterType.ANNOTATION, value=Controller.class)
		}
 )
//<mvc:annotation-driven/>
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	
// <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//      <beans:property name="prefix" value="/WEB-INF/views/" />
//	    <beans:property name="suffix" value=".jsp" />
//	    <beans:property name="order"  value="0" />		
// </bean>
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setOrder(0);
		
		return internalResourceViewResolver;
	}

}
