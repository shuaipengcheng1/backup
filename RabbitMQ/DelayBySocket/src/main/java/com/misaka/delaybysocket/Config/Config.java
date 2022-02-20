package com.misaka.delaybysocket.Config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
//通过延迟插件来实现延迟消息
public class Config {
    //    延迟交换机的名字
    String Delay = "Delay.exchange";
    //    router
    String q1_r = "Delay.router";
    //    队列
    String q1_q = "Delay.Queue";
    //    死信交换机
    String d_exchange = "d_exchange_Socket";
    //    死信队列
    String d_q = "d_queue_Socket";
    //    死信router
    String d_r = "d_r";


    //    声明队列
    @Bean("q1")
    public Queue q1() {
//        return QueueBuilder.durable(q1_q).deadLetterExchange(d_exchange).deadLetterRoutingKey(d_r).build();
        return QueueBuilder.durable(q1_q).build();
    }


    @Bean("d1")
    public Queue d1() {
        return QueueBuilder.durable(d_q).build();
    }

    //    创建交换机 为用户自定义交换机类型
    @Bean("Delay_Exchange")
    public CustomExchange delayExchange() {
//        是一个类
        Map map = new HashMap();
        map.put("x-delayed-type", "direct");
//        参数  名称 类型 是否持久化 是否自动删除 其他参数(Map)
        return new CustomExchange(Delay, "x-delayed-message", false, false, map);
    }

    //    创建死信交换机
    @Bean("Dead_exchange")
    public DirectExchange Dead() {
        return new DirectExchange(d_exchange);
    }

    //    绑定
    @Bean
    public Binding q1AndDelay(@Qualifier("q1") Queue q1, @Qualifier("Delay_Exchange") CustomExchange exchange) {
        // 需要构建方法
        return BindingBuilder.bind(q1).to(exchange).with(q1_r).noargs();
    }

    @Bean
    public Binding d1AndD(@Qualifier("d1") Queue d1, @Qualifier("Dead_exchange") DirectExchange directExchange) {
        return BindingBuilder.bind(d1).to(directExchange).with(d_r);

    }

}
