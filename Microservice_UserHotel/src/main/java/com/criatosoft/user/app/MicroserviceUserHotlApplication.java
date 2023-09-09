package com.criatosoft.user.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceUserHotlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUserHotlApplication.class, args);
		
	}
	@Bean
	public RestTemplate restTemplet() {
		return new RestTemplate();
	}

}
