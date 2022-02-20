package com.day3.provi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//zookeeper
@EnableDiscoveryClient
public class ProviApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviApplication.class, args);
    }

}
