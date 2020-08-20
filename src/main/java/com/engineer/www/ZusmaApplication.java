package com.engineer.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.engineering.www.controllers.web", "com.engineering.www.controllers.rest","com.engineering.www.managers.db"})
public class ZusmaApplication {

	public static void main(String[] args) {
		 System.setProperty("spring.devtools.restart.trigger-file", ".reloadtrigger");
		SpringApplication.run(ZusmaApplication.class, args);
	}
	
}
