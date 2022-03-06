package com.recipe.config;

//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//		.antMatchers("/", "/login", "/signup", "/adduser").permitAll()
//		.antMatchers("/post").hasAnyRole("USER","ADMIN")
//		.antMatchers("/admin").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		
//		.and()
//		.formLogin()
//		.loginProcessingUrl("/login")
//		.defaultSuccessUrl("/post")
//		
//		.and()
//		.logout()
//		.logoutSuccessUrl("/")
//		.invalidateHttpSession(true);
//		
//		log.info("Config Success");
//		
//	}
//	
//
//}
