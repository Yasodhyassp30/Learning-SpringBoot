package com.gateway.gatwayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatwayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatwayServerApplication.class, args);
	}

}
