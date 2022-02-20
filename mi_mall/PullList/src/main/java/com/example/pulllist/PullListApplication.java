package com.example.pulllist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PullListApplication {

    public static void main(String[] args) {
        SpringApplication.run(PullListApplication.class, args);
    }

}
