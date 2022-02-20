package com.day11.gateway_day11.Config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class Filter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入filter");
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname==null){
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
           return exchange.getResponse().setComplete();
        }else
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
