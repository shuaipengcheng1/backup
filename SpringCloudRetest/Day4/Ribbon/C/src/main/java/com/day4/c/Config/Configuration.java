package com.day4.c.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();

    }
}
