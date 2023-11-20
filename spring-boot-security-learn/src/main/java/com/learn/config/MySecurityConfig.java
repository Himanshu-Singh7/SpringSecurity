package com.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		 .authorizeRequests()
		 .anyRequest()
		 .authenticated()
		 .and()
		 .httpBasic();
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("jhon").password("12345").roles("ROLE_NORMAL");
		auth.inMemoryAuthentication().withUser("pratiksha").password("abc").roles("ROLE_ADMIN");
	}

	
	

	
	
}
