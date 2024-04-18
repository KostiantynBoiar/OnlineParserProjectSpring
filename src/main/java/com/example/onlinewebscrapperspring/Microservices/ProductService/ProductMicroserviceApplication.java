package com.example.onlinewebscrapperspring.Microservices.ProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ProductMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.example.onlinewebscrapperspring.Microservices.UserService.UserMicroserviceApplication.class, args);
    }
}