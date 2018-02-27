package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevelopmentDev {

	@Bean
	public EnvConfiguration devlopment() {

		return new DevelopmentEnv();

	}

}
