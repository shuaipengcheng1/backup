package com.mi.cursel_ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurselAdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurselAdApplication.class, args);
    }

}
