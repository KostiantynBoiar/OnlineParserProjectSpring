package com.example.onlinewebscrapperspring.Microservices.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class UserMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserMicroserviceApplication.class, args);
    }
}
