package com.sri.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("srikanta").password("{noop}sri").roles("manager");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("hello");
		http.authorizeHttpRequests()
		.antMatchers("/").permitAll()
		.antMatchers(HttpMethod.GET,"/bank/withdraw").authenticated()

		.antMatchers(HttpMethod.POST,"/bank/withdraw").authenticated()
		.and()
		.formLogin().defaultSuccessUrl("/bank", true)
		.and()
		.logout();
		//if we disable csrf then only we send post mode request otherwise throws 403 exception
		http.csrf().disable();
	}
}
