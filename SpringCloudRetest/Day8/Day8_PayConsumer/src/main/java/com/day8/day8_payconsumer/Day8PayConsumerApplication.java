package com.day8.day8_payconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//开启Eureka

@EnableEurekaClient
//开启hystrix
@EnableCircuitBreaker
//开启OpenFeign
@EnableFeignClients
public class Day8PayConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day8PayConsumerApplication.class, args);
    }

}
