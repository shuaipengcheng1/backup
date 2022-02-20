package com.day10.day10_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Day10EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day10EurekaApplication.class, args);
    }

}
