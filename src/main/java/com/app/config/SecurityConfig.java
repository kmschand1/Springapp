package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private UserDetailsService Userservice;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.userDetailsService(Userservice)
		.passwordEncoder(encoder);

	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		
		http.csrf().disable()
		.authorizeRequests().antMatchers("/save","/all","/reg").permitAll()
		.antMatchers("/student").hasAuthority("STUDENT")
		.antMatchers("/admin").hasAnyAuthority("ADMIN")
		.antMatchers("/emp").hasAnyAuthority("EMPLOYEE")
		.anyRequest().authenticated()
		.and()
		.formLogin().defaultSuccessUrl("/common",true)
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denide")
		;
		
		
	}
	
	
}
