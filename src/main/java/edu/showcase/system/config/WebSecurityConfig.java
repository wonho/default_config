package edu.showcase.system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("1111").roles("USER").and()
				.withUser("admin").password("2222").roles("USER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .authorizeRequests().anyRequest().authenticated()
			.and()
		    .formLogin()
		        .loginPage("/auth/login.do")
		        .defaultSuccessUrl("/auth/main.do")
		        .failureUrl("/auth/login.do")
		        .permitAll()
		        .and()
		        .logout();
		
//		http
//		.authorizeRequests()                                                                
//			.antMatchers("/resources/**", "/signup", "/about").permitAll()                  
//			.antMatchers("/admin/**").hasRole("ADMIN")                                      
//			.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")            
//			.anyRequest().authenticated()                                                   
//			.and()
//		.formLogin();
		
		
//		<security:http auto-config='true'>
//		  ...
//		  <security:intercept-url pattern="/**" access="IS_AUTHENTICATED_FULLY"/>
//		  <security:form-login login-page="/login" default-target-url="/sites"
//		                     authentication-failure-url="/login"
//		                     authentication-success-handler-ref="authenticationSuccessHandler"/>
//		 ...		
		
		
//		 http
//	       .authorizeRequests()
//	          .anyRequest().authenticated()
//	          .and()
//	        .formLogin()
//	          .loginPage("/login")
//	          .failureUrl("/login")
//	          .and()
//	        .logout()
//	          .permitAll()
//	          .and()
		
		
//		 http
//	        .authorizeRequests()
//	          .anyRequest().authenticated()
//	          .and()
//	        .formLogin()
//	          .loginPage("/login")
//	          .defaultSuccessUrl("/sites")
//	          .failureUrl("/login")
//	          .successHandler(yourSuccessHandlerBean) // autowired or defined below
//	          .and()
//	        .logout()
//	          .permitAll()
//	          .and()

	
		
	}
}
