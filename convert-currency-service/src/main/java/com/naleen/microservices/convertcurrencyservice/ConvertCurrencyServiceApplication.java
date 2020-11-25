package com.naleen.microservices.convertcurrencyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.naleen.microservices.convertcurrencyservice")
@EnableDiscoveryClient
public class ConvertCurrencyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertCurrencyServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
