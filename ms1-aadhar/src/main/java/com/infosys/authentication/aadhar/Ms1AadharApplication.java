package com.infosys.authentication.aadhar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Ms1AadharApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms1AadharApplication.class, args);
	}

}
