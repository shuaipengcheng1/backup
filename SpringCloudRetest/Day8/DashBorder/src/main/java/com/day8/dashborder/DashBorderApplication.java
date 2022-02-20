package com.day8.dashborder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashBorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashBorderApplication.class, args);
    }

}
