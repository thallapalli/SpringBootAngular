package com.cts.osp.kt.osp.security;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cts.osp.kt.osp.controller.FsdController;
import com.cts.osp.kt.osp.service.AppUserDetailsService;

@Configurable
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter{
	public static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	// This method is for overriding the default AuthenticationManagerBuilder.
	// We can specify how the user details are kept in the application. It may
	// be in a database, LDAP or in memory.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService);
	}

	// this configuration allow the client app to access the this api 
	// all the domain that consume this api must be included in the allowed o'rings 

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
	          
	        }
	    };
	}
	// This method is for overriding some configuration of the WebSecurity
	// If you want to ignore some request or request patterns then you can
	// specify that inside this method
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	// This method is used for override HttpSecurity of the web Application.
	// We can specify our authorization criteria inside this method.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info(" start configure");
		
		http.cors().and()
		// starts authorizing configurations
		.authorizeRequests()
		// ignoring the guest's urls "
		//.antMatchers("/fsd/register","/fsd/login","/logout","/**").permitAll() //to disable security
		.antMatchers("/fsd/register","/fsd/login","/logout").permitAll()
		// authenticate all remaining URLS
		.anyRequest().fullyAuthenticated().and()
      /* "/logout" will log the user out by invalidating the HTTP Session,
       * cleaning up any {link rememberMe()} authentication that was configured, */
		.logout()
        .permitAll()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
        .and()
		// enabling the basic authentication
		.httpBasic().and()
		// configuring the session on the server
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
		// disabling the CSRF - Cross Site Request Forgery
		 .csrf().disable().addFilter(new JWTAuthenticationFilter(authenticationManager()))
		 .addFilter(new JWTAuthorizationFilter(authenticationManager()));
		logger.info(" end configure");
		
		
	}
}
