package edu.showcase.system.config;

import java.security.Principal;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;

//https://gs.saro.me/#!m=elec&jn=835
//https://github.com/spring-projects/spring-security-oauth
//https://github.com/cloudfoundry/uaa

@EnableOAuth2Client
public class OAuth2WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//	    .authorizeRequests()
//	    .antMatchers("/auth/login.do").hasRole("admin")
//	    .antMatchers("/message/**").permitAll()
//	    .anyRequest().authenticated()
//		.and()
//	    .formLogin()
//	        .loginPage("/auth/login.do")
//	        .defaultSuccessUrl("/auth/main.do")
//	        .loginProcessingUrl("/auth/loginProcess.do")
//	        .failureUrl("/auth/login.do")
//	        .permitAll()
//	        .and()
//	    .logout()
//	        .and()
//	    .csrf().disable();
	
		// @formatter:off
		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**").permitAll().anyRequest()
				.authenticated().and().exceptionHandling()
				.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/")).and().logout()
				.logoutSuccessUrl("/").permitAll().and().csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
				.addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
		// @formatter:on
	}	
	
	@Bean
	public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(filter);
		registration.setOrder(-100);
		return registration;
	}

	private Filter ssoFilter() {
		OAuth2ClientAuthenticationProcessingFilter facebookFilter = new OAuth2ClientAuthenticationProcessingFilter(
				"/login/facebook");
		OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(), oauth2ClientContext);
		facebookFilter.setRestTemplate(facebookTemplate);
		UserInfoTokenServices tokenServices = new UserInfoTokenServices(facebookResource().getUserInfoUri(),
				facebook().getClientId());
		tokenServices.setRestTemplate(facebookTemplate);
		facebookFilter.setTokenServices(
				new UserInfoTokenServices(facebookResource().getUserInfoUri(), facebook().getClientId()));
		return facebookFilter;
	}

	
//	facebook.client.clientId: 233668646673605
//	facebook.client.clientSecret: 33b17e044ee6a4fa383f46ec6e28ea1d
//	facebook.client.accessTokenUri: https://graph.facebook.com/oauth/access_token
//	facebook.client.userAuthorizationUri: https://www.facebook.com/dialog/oauth
//	facebook.client.tokenName: oauth_token
//	facebook.client.authenticationScheme: query
//	facebook.client.clientAuthenticationScheme: form
//	# 스코프는 제가 임시로 넣어봤습니다. 이런식으로 권한을 추가할 수 있습니다.
//	facebook.client.scope: public_profile,email,user_birthday

	@Value("${facebook.client.clientId}")
	String clientId;
	@Value("${facebook.client.clientSecret}")
	String clientSecret;
	@Value("${facebook.client.accessTokenUri}")
	String accessTokenUri;
	@Value("${facebook.client.userAuthorizationUri}")
	String userAuthorizationUri;
	@Value("${facebook.client.tokenName}")
	String tokenName;
	@Value("${facebook.client.authenticationScheme}")
	AuthenticationScheme clientAuthenticationScheme;
	@Value("${facebook.client.clientAuthenticationScheme}")
	AuthenticationScheme authorizationScheme;
	
	@Bean
	public AuthorizationCodeResourceDetails facebook() {
		AuthorizationCodeResourceDetails authorizationCodeResourceDetails = new AuthorizationCodeResourceDetails();
		authorizationCodeResourceDetails.setClientId(clientId);
		authorizationCodeResourceDetails.setClientSecret(clientSecret);
		authorizationCodeResourceDetails.setAccessTokenUri(accessTokenUri);
		authorizationCodeResourceDetails.setUserAuthorizationUri(userAuthorizationUri);
		authorizationCodeResourceDetails.setTokenName(tokenName);
		authorizationCodeResourceDetails.setAuthenticationScheme(authorizationScheme);
		authorizationCodeResourceDetails.setClientAuthenticationScheme(clientAuthenticationScheme);
		
		return authorizationCodeResourceDetails;
	}

	@Value("${facebook.resource.userInfoUri}")
	String userInfoUri;
	
	@Bean
	public ResourceServerProperties facebookResource() {
		ResourceServerProperties resourceServerProperties = new ResourceServerProperties();
		resourceServerProperties.setUserInfoUri(userInfoUri);
		return resourceServerProperties;
	}
	
}
