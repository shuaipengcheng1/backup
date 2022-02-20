package com.misaka.delaybysocketretest.Config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfirmConfig {
    //    发布确认高级的配置类
    String Exchange = "confirm.exchange";
    String Router = "key1";
    String Queue = "confirm.queue";

    //    备份交换机 用于处理发送失败的消息
    String BackUpExchange = "BackUpExchange";
    //    备份队列
    String BackUpQueue = "BackUpQueue";
    //    报警队列
    String WarnQueue = "WarnQueue";



    //    创建队列
    @Bean("QUEUE")
    public org.springframework.amqp.core.Queue Q() {
        return QueueBuilder.durable(Queue).build();
    }
//声明备份交换机
    @Bean("backup")
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(BackUpExchange);
    }
    //    创建队列
    @Bean("BackQUEUE")
    public org.springframework.amqp.core.Queue B() {
        return QueueBuilder.durable(BackUpQueue).build();
    }    //    创建队列
    @Bean("WarnQUEUE")
    public org.springframework.amqp.core.Queue W() {
        return QueueBuilder.durable(WarnQueue).build();
    }
    //    创建交换机
    @Bean("Confirm_Exchange")
    public DirectExchange exchange() {
        return ExchangeBuilder.directExchange(Exchange).durable(true).alternate(BackUpExchange).build();
    }
    //    绑定
    @Bean
    public Binding bind(@Qualifier("Confirm_Exchange") DirectExchange exchange, @Qualifier("QUEUE") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(Router);
    }
    @Bean
    public Binding bindw(@Qualifier("backup") FanoutExchange exchange, @Qualifier("BackQUEUE") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange);
    }  @Bean
    public Binding bindb(@Qualifier("backup") FanoutExchange exchange, @Qualifier("WarnQUEUE") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange);
    }

}
