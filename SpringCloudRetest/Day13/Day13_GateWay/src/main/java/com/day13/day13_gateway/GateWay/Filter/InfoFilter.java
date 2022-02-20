package com.day13.day13_gateway.GateWay.Filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class InfoFilter implements GatewayFilter, Ordered {
//    参数id不能低于0

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        获取参数
        int id = Integer.parseInt(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("id")));
        if(id<1){
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
