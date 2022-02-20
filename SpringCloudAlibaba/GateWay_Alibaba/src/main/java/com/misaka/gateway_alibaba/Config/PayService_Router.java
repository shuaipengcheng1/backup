package com.misaka.gateway_alibaba.Config;

import com.misaka.gateway_alibaba.Filter.PayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class PayService_Router {
    /*
    * spring.cloud.gateway.routes[0].id=Pay
      spring.cloud.gateway.routes[0].uri=http://localhost:7001
      spring.cloud.gateway.routes[0].predicates[0]=Path=/pay/**
    * */
    @Bean
    public RouteLocator locator(RouteLocatorBuilder builder){

       return  builder.routes().route("x",
//               添加专属Filter
               r->r.path("/pay/**").uri("lb://provider").filter(new PayFilter())
       ).build();
    }


}
