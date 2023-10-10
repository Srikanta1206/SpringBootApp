package com.sri.register_intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Component
public class RegisterIntercepter implements WebMvcConfigurer {

	@Autowired
	private LocaleChangeInterceptor inter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(inter);
	}
}
