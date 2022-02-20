package com.mi.gateway.Router;

import com.mi.gateway.FilterHandler.CheckLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoginSubmit {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return  routeLocatorBuilder.routes().route("login",r->r.path("/login").uri("http://localhost:1001")).build();
    }
    @Bean
    public RouteLocator Submit(RouteLocatorBuilder routeLocatorBuilder){
        return  routeLocatorBuilder.routes().route("Submit",r->r.path("/Submit").uri("http://localhost:1001")).build();
    }
    @Bean
    public RouteLocator Check(RouteLocatorBuilder routeLocatorBuilder){
        return  routeLocatorBuilder.routes().route("check",r->r.path("/check").uri("http://localhost:1001")).build();
    }

}
