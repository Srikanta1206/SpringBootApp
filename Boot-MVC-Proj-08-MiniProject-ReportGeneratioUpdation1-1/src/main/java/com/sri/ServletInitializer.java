package com.sri;

import java.util.Locale;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@SpringBootApplication
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootMvcProj08MiniProjectReportGeneratioUpdation11Application.class);
	}
	
	@Bean("localeResolver")
	public SessionLocaleResolver resolver() {
		SessionLocaleResolver resolv=new SessionLocaleResolver();
		resolv.setDefaultLocale(Locale.ENGLISH);
		return resolv;
	}
	
	@Bean("intercepter")
	public LocaleChangeInterceptor intercepter() {
		
		LocaleChangeInterceptor inter=new LocaleChangeInterceptor();
		inter.setParamName("lang");
		return inter;
	}	
}
