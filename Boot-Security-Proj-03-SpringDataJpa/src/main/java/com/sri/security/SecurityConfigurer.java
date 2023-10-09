package com.sri.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sri.service.IServiceMgmt;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private IServiceMgmt service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/bank").permitAll()
		.antMatchers("/user/registration","/user/show_login").permitAll()
		.antMatchers("/bank/loans_approve").hasRole("Manager")
		.antMatchers("/bank/balance").authenticated()
		.antMatchers("/bank/withdraw").hasAnyRole("Manager","Customer")
		.antMatchers("/bank/loan_apply").hasRole("Customer")
		.and()
		.formLogin().defaultSuccessUrl("/bank/", true).loginPage("/user/show_login").loginProcessingUrl("/login").permitAll()
		.and()
		.logout()
		.and()
		.exceptionHandling().accessDeniedPage("/denied")
		.and()
		.sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
//		http.csrf().disable();
	}
}
