package com.mi.gateway.Router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Ad {
    @Bean
    public RouteLocator Ad(RouteLocatorBuilder builder){
        return builder.routes().route("cursels",r->r.path("/getCursel").uri("http://localhost:1005")).build();
    }
}
