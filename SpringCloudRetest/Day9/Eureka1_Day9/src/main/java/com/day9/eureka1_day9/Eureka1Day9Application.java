package com.day9.eureka1_day9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka1Day9Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka1Day9Application.class, args);
    }

}
