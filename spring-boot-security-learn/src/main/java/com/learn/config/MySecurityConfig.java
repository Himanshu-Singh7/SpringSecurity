package com.learn.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		 .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		 .and()
		 .authorizeRequests()
		 .antMatchers("/signin").permitAll()
		 .antMatchers("/public/**").hasRole("NORMAL")
		 .antMatchers("/users/**").hasRole("ADMIN")
		 .anyRequest()
		 .authenticated()
		 .and()
		 .formLogin()
		 .loginPage("/signin");
		
		
	}

	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("jhon").password(this.passwordEncoder().encode("12345")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("pratiksha").password(this.passwordEncoder().encode("abc")).roles("ADMIN");
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
		
	}
	

	
	
}
