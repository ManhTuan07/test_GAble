package com.example.testgable;

import com.example.testgable.service.CoinServerData;
import com.example.testgable.service.impl.CoinServerDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.testgable.configuration")
public class TestgableApplication {
	public static void main(String[] args) {
		CoinServerDataImpl coinServerData = new CoinServerDataImpl();
		coinServerData.print();
		SpringApplication.run(TestgableApplication.class, args);


	}

}
