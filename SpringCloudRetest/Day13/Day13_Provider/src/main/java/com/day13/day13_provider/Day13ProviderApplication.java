package com.day13.day13_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//开启
@EnableDiscoveryClient

public class Day13ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day13ProviderApplication.class, args);
    }

}
