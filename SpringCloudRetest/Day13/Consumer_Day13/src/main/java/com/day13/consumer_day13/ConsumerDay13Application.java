package com.day13.consumer_day13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerDay13Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDay13Application.class, args);
    }

}
