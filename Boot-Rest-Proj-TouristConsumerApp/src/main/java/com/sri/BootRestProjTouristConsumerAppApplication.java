package com.sri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class BootRestProjTouristConsumerAppApplication {

    public static void main(String[] args) {
	SpringApplication.run(BootRestProjTouristConsumerAppApplication.class, args);
    }

    @Bean
    public RestTemplate createTemplate() {
	return new RestTemplate();
    }

    @Bean
    public ObjectMapper cretaeMapper() {
	return new ObjectMapper();
    }

}
