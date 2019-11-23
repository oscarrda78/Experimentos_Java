package com.emotel.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages= {
"com.emotel.core", "com.emotel.web"})
public class EMotelWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EMotelWebApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EMotelWebApplication.class);
	}
	
}
