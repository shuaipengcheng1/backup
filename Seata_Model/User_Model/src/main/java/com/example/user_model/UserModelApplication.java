package com.example.user_model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserModelApplication.class, args);
    }

}
