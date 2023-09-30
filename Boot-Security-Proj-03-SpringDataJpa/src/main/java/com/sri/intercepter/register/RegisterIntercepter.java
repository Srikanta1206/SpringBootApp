package com.sri.intercepter.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class RegisterIntercepter implements WebMvcConfigurer{

	@Autowired
	private HandlerInterceptor intercepter;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(intercepter);
	}
}
