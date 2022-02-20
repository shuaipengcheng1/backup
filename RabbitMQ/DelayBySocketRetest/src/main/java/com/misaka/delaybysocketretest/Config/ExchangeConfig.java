package com.misaka.delaybysocketretest.Config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ExchangeConfig {
//    延迟队列 通过插件实现
//    效果    P ---> Ex(x-delayed-message) --router(N_R)--> Queue ----> C
//交换机名
    String Exchange = "Retest_Socket";
//    队列名
    String Queue = "Retest_Queue";
//    路由
    String RoutingKey = "N_R";

//    声明交换机
    @Bean("E")
    public CustomExchange customExchange (){
        Map map =new HashMap();
        map.put("x-delayed-type","direct");
        return new CustomExchange(Exchange,"x-delayed-message",true,false,map);
    }
//    声明队列
    @Bean("N_Q")
    public org.springframework.amqp.core.Queue queue(){
        return QueueBuilder.durable(Queue).build();
    }
//    绑定
    @Bean
    public Binding binding(@Qualifier("N_Q")Queue queue,@Qualifier("E") CustomExchange customExchange){
        return BindingBuilder.bind(queue).to(customExchange).with(RoutingKey).noargs();
    }



}
