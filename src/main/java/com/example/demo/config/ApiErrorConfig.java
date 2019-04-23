package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.hibicode.beerstore.error.ApiExceptionHandler;

@Configuration
public class ApiErrorConfig {
	
	@Bean
	public MessageSource apiErrorMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:/api_errors");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
