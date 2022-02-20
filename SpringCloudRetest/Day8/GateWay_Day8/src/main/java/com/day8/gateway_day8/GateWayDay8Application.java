package com.day8.gateway_day8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GateWayDay8Application {
//给8001 接口套上网关 网关端口9527
    public static void main(String[] args) {
        SpringApplication.run(GateWayDay8Application.class, args);
    }

}
