package edu.showcase.system.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
//	@Bean
//	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
//		RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
//		List<HttpMessageConverter<?>> messageConverters;
//		handlerAdapter.setMessageConverters(messageConverters);
//		return null;
//	}
	
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
	
//	  <mvc:annotation-driven>    
//	    <mvc:argument-resolvers>
//	     	  <beans:bean class="edu.showcase.system.ux.UxWebArgumentResolver"/>
//	    </mvc:argument-resolvers>
//      
//	    	<mvc:message-converters>
//			        <beans:bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
//			        	<beans:property name="supportedMediaTypes" value="application/json"/>
//			        </beans:bean>
//			        <beans:bean class="org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter">
//			        	<beans:property name="supportedMediaTypes" value="application/xml"/>
//			        </beans:bean>
//	        </mvc:message-converters>
//       </mvc:annotation-driven>	
	
	@Bean
	public MappingJackson2HttpMessageConverter jsonConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
//		MediaType.parseMediaType("application/json");
		jsonConverter.setSupportedMediaTypes(supportedMediaTypes);
		ObjectMapper objectMapper = new ObjectMapper();
		jsonConverter.setObjectMapper(objectMapper);		
		return jsonConverter;
	}

	@Bean
	public MappingJackson2XmlHttpMessageConverter xmlConverter() {
		MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.APPLICATION_XML);
		xmlConverter.setSupportedMediaTypes(supportedMediaTypes);
		return xmlConverter;
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
		super.configureContentNegotiation(configurer);
	}

	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(xmlConverter());
		converters.add(jsonConverter());
		super.configureMessageConverters(converters);
	}
	
}
