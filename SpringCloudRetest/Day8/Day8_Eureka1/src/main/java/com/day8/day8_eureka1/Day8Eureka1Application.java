package com.day8.day8_eureka1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Day8Eureka1Application {

    public static void main(String[] args) {
        SpringApplication.run(Day8Eureka1Application.class, args);
    }

}
