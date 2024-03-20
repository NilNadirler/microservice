package com.example.gateaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class GateawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateawayApplication.class, args);
	}

}
