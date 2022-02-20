package com.mi.gateway.Router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PullBack {
    @Bean
    public RouteLocator Pull(RouteLocatorBuilder routeLocatorBuilder){
        return  routeLocatorBuilder.routes().route("pull",r->r.path("/getPull").uri("http://localhost:1009")).build();
    }
}
