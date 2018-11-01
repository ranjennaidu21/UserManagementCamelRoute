package com.candela.iam.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UsermanagementApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(UsermanagementApplication.class);
	}
}
