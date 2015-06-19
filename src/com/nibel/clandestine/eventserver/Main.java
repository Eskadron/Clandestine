package com.nibel.clandestine.eventserver;

import org.springframework.boot.SpringApplication;

public class Main {
	public static void main(String[] args){
		SpringApplication springApp = new SpringApplication(EventServerSpringConfiguration.class);
		springApp.run(args);
	}
}
