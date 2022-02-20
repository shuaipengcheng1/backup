package com.day13.day13_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class Day13GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day13GateWayApplication.class, args);
    }

}
