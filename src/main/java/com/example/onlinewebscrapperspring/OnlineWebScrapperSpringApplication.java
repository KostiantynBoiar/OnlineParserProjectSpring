package com.example.onlinewebscrapperspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class OnlineWebScrapperSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineWebScrapperSpringApplication.class, args);
    }

}
