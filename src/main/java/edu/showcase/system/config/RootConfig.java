package edu.showcase.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

import edu.showcase.system.util.MessageUtil.MessageUtil;

/*

<!--  "${jdbc.driver}"
	<context:property-placeholder location="classpath:app.properties" /> 
-->

<!-- 
    SpEL 이용 "#{db['jdbc.driver']}" , @Value("#{db['jdbc.driver']}") String value
	<util:properties id="db" location="/WEB-INF/resource/app.properties" />     
-->	

	
	<context:component-scan base-package="edu.showcase.business">
	<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
	</context:component-scan>
	
	<bean id="messageSource"
		class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
		<property name="basenames">
			<array>
				<value>WEB-INF/messages/messages</value>
			</array>
		</property>
		
		<property name="defaultEncoding" value="UTF-8"/>
	<!--  property name="fallbackToSystemLocale" value="false"/> -->
	<!-- <property name="cacheSeconds" value="30"/> -->	
	</bean>
	
	/WEB-INF/classes/conf/messages
    classpath:conf/messages	
*/

@Configuration
@ComponentScan(basePackages={"edu.showcase"}, 
               excludeFilters=@ComponentScan.Filter(type=FilterType.ANNOTATION,
               value=Controller.class))
@PropertySource("classpath:properties/app.properties")

//@PropertySources({@PropertySource("classpath:properties/app.properties"),
//	              @PropertySource("classpath:properties/dev.properties")
public class RootConfig {
	
	@Autowired
    Environment env;
	
	@Value("#{systemProperties['mongodb.port'] ?: 27017}")
	private String mongodbPort;

	private @Value("${dev.jdbc.url}") String url;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	 
	@Bean
	public MessageSource messageSource() {		
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename("classpath:messages/messages");
		
		messageSource.setBasename("WEB-INF/messages/messages");
		messageSource.setDefaultEncoding("UTF-8");
		
//		messageSource.setUseCodeAsDefaultMessage(true);
		// default : true -> message_ko_KR.properties 와 message.prorperties 
//		messageSource.setFallbackToSystemLocale(false);
//		messageSource.setCacheSeconds(30);
		
		return messageSource;
	}
	
	@Bean
	public MessageUtil messageUtil() {
		MessageUtil messageUtil = new MessageUtil();
		messageUtil.setMessageSource(messageSource());		
		return messageUtil;
	}

}
