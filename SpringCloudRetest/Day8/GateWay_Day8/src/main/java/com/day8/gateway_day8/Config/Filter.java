package com.day8.gateway_day8.Config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class Filter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("***come in Filter");
//        获取请求的参数
       String uname= exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname==null){
            System.out.println("为空");
//            设置状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            返回结果
            return exchange.getResponse().setComplete();
        }
//        正常返回
        return chain.filter(exchange);

    }

    @Override
//    加载过滤器实现类类的顺序 值越小 优先级越高 类似加权重
    public int getOrder() {
        return 0;
    }
}
