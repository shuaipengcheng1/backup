package com.day2.pro2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Pro2Application {

    public static void main(String[] args) {
        SpringApplication.run(Pro2Application.class, args);
    }

}
