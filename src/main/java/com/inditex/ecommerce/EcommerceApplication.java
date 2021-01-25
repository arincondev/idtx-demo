package com.inditex.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@SpringBootApplication
public class EcommerceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
