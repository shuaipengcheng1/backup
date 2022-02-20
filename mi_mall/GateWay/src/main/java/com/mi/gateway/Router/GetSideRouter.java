package com.mi.gateway.Router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GetSideRouter {
    @Bean
    public RouteLocator getSide(RouteLocatorBuilder routeLocatorBuilder){

        return  routeLocatorBuilder.routes().route("getSide",r->r.path("/getSide").uri("http://localhost:1003")).build();
    }
}
