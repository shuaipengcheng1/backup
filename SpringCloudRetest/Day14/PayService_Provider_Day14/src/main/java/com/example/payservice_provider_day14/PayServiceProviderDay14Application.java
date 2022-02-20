package com.example.payservice_provider_day14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PayServiceProviderDay14Application {

    public static void main(String[] args) {
        SpringApplication.run(PayServiceProviderDay14Application.class, args);
    }

}
