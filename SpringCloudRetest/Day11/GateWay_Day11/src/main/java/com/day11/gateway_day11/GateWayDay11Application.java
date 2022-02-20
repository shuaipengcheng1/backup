package com.day11.gateway_day11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateWayDay11Application {

    public static void main(String[] args) {
        SpringApplication.run(GateWayDay11Application.class, args);
    }

}
