package com.day5.eure1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eure1Application {

    public static void main(String[] args) {
        SpringApplication.run(Eure1Application.class, args);
    }

}
