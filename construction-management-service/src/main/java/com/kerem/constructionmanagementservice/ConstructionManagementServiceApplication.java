package com.kerem.constructionmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConstructionManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstructionManagementServiceApplication.class, args);
	}

}
