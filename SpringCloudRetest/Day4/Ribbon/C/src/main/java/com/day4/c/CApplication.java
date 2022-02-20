package com.day4.c;

import com.day4.config.Ribbon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "PAY",configuration = Ribbon.class)
public class CApplication {

    public static void main(String[] args) {
        SpringApplication.run(CApplication.class, args);
    }

}
