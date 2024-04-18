package com.example.onlinewebscrapperspring.Microservices.UserService.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@PropertySource("classpath:users-service-application.properties")
public class WebConfiguration {

}
