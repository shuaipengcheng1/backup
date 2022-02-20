package comday9.gateway_day9.Filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//设置全局过滤器
@Component
public class PayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        获取参数 uname
      String uname=  exchange.getRequest().getQueryParams().getFirst("uname");
      if(uname==null){
          exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
       return    exchange.getResponse().setComplete();
      }else
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
