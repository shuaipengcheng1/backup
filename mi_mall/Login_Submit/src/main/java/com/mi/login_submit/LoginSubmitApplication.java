package com.mi.login_submit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoginSubmitApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginSubmitApplication.class, args);
    }

}
