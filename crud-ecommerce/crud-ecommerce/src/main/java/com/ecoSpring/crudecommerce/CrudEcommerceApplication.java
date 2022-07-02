package com.ecoSpring.crudecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CrudEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudEcommerceApplication.class, args);
	}

}
