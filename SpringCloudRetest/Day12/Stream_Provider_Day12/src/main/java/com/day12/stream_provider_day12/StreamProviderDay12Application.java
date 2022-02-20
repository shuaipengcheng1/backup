package com.day12.stream_provider_day12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class StreamProviderDay12Application {

    public static void main(String[] args) {
        SpringApplication.run(StreamProviderDay12Application.class, args);
    }

}
