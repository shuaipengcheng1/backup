package com.day12.eureka_day12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDay12Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDay12Application.class, args);
    }

}
