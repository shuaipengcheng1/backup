package com.day11.dashborad_day11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashBoradDay11Application {

    public static void main(String[] args) {
        SpringApplication.run(DashBoradDay11Application.class, args);
    }

}
