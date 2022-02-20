package com.day4.e2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class E2Application {

    public static void main(String[] args) {
        SpringApplication.run(E2Application.class, args);
    }

}
