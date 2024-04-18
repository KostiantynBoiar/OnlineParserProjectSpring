package com.example.onlinewebscrapperspring;

import com.example.onlinewebscrapperspring.Microservices.ProductService.ProductMicroserviceApplication;
import com.example.onlinewebscrapperspring.Microservices.UserService.UserMicroserviceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class OnlineWebScrapperSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMicroserviceApplication.class, args);
        SpringApplication.run(ProductMicroserviceApplication.class, args);
    }

}
