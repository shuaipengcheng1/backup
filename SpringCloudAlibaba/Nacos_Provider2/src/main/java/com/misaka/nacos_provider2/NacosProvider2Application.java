package com.misaka.nacos_provider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider2Application.class, args);
    }

}
