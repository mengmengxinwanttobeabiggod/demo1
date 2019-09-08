package com.hsq.springboot.study.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class CorsConfig  extends WebMvcConfigurerAdapter {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		 registry.addMapping("/**").allowedOrigins("*")  
         .allowCredentials(true)  
         .allowedMethods(HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name(),
 				HttpMethod.DELETE.name(), HttpMethod.OPTIONS.name(), HttpMethod.PUT.name()) 
         .maxAge(3600); 
	}

}
