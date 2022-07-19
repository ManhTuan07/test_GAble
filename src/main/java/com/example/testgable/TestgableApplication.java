package com.example.testgable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.testgable.configuration")
public class TestgableApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestgableApplication.class, args);
	}

}
