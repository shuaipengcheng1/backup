package com.mi.gateway.FilterHandler;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;
//import org.springframework.core.annotation.Order;
@Component
public class CheckLoginFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

//        获取cookie
        if(exchange.getRequest().getCookies().getFirst("username")!=null){
//       ok
         return    chain.filter(exchange);
        }else{
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            ServerHttpResponse response = (ServerHttpResponse) exchange.getResponse();

            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
