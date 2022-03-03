package com.recipe.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/", "/login", "/signup", "/adduser").permitAll()
		.antMatchers("/post").hasAnyRole("USER","ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/post", true)
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.invalidateHttpSession(true);
		
		log.info("Config Success");
		
	}
	

}
