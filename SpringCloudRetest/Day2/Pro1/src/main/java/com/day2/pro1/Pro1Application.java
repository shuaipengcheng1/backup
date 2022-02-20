package com.day2.pro1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Pro1Application {

    public static void main(String[] args) {
        SpringApplication.run(Pro1Application.class, args);
    }

}
