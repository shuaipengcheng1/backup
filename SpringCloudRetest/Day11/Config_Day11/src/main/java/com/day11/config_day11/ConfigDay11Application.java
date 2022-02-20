package com.day11.config_day11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//开启Config
@EnableConfigServer
//开启Eureka
@EnableEurekaClient
public class ConfigDay11Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigDay11Application.class, args);
    }

}
