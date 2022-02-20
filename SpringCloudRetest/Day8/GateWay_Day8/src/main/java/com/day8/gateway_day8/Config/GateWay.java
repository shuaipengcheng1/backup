package com.day8.gateway_day8.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

@Configuration
public class GateWay {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder route = routeLocatorBuilder.routes();
//        当你访问http://localhost:9527/pay/**时 自动转发到http://localhost:7001/pay/**
//        route.route("Pay", r -> r.path("/pay/**").uri("lb://pay")).build();
        return route.build();
    }
}

