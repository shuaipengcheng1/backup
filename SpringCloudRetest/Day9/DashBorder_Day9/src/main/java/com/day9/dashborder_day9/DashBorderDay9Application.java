package com.day9.dashborder_day9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashBorderDay9Application {

    public static void main(String[] args) {
        SpringApplication.run(DashBorderDay9Application.class, args);
    }

}
