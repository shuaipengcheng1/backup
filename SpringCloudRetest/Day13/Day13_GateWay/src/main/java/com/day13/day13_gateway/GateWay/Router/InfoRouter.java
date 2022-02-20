package com.day13.day13_gateway.GateWay.Router;

import com.day13.day13_gateway.GateWay.Filter.InfoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InfoRouter {
    @Autowired
    InfoFilter infoFilter;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route(
                "info", r -> r.path("/info/**").uri("lb://provider").filter(infoFilter)
        ).build();
    }
}
