package com.example.day11_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Day11ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day11ConsumerApplication.class, args);
    }

}
