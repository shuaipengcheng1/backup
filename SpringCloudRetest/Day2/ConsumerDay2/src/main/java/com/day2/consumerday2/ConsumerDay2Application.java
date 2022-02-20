package com.day2.consumerday2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerDay2Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerDay2Application.class, args);
    }

}
