package com.misaka.lastretest.Config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {
    //    延迟交换机
    String DelayedExchange = "DelayedExchange";
    //    延迟队列
    String DelayedQueue = "DelayedQueue";
    //    延迟队列的routingKey
    String DelayedRoutingKey = "DQ1";

    //    普通交换机
    String normal_Exchange = "normalExchange";
    //    普通交换机队列
    String Queue1 = "Queue1";
    String Queue2 = "Queue2";
    //    普通交换机的routingKey
    String Queue1_Key = "1";
    String Queue2_Key = "2";

    //    队列Queue1 2的死信交换机
    String Dead_Exchange = "Dead_Exchange";
    //    死信队列
    String Dead_Queue = "Dead_Queue";
    //    死信队列路由
    String Dead_Routing = "Dead";

    //    普通交换机的备份交换机 Fanout
    String normal_Exchange_Backup = "normal_Exchange_Backup";
    // 备份交换机的队列
    String backUp_Queue = "BackUp";
    String Warn_Queue = "WARN";

    //    声明延迟交换机
    @Bean("DelayEd_Exchange")
    public CustomExchange customExchange() {
        Map map = new HashMap();
        map.put("x-delayed-type", "direct");
        return new CustomExchange(DelayedExchange, "x-delayed-message", true, false, map);
    }

    //    声明延迟队列
    @Bean("Delayed_Queue")
    public Queue DelayedQueue() {
        return QueueBuilder.durable(DelayedQueue).build();
    }

    //    绑定
    @Bean
    public Binding DeBDQ(@Qualifier("DelayEd_Exchange") CustomExchange customExchange, @Qualifier("Delayed_Queue") Queue queue) {
        return BindingBuilder.bind(queue).to(customExchange).with(DelayedRoutingKey).noargs();
    }

    //    创建备份交换机
    @Bean("backExchange")
    public FanoutExchange back() {
        return new FanoutExchange(normal_Exchange_Backup);
    }

    //    创建普通交换机
    @Bean("Exchange")
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(normal_Exchange).alternate(normal_Exchange_Backup).durable(true).build();
    }

    //创建死信
    @Bean("DeadExchange")
    public DirectExchange Dead() {
        return ExchangeBuilder.directExchange(Dead_Exchange).durable(true).build();
    }

    //    创建死信队列
    @Bean("DeadQueue")
    public Queue DeadQ() {
        return QueueBuilder.durable(Dead_Queue).build();
    }

    //    创建普通队列
    @Bean("Q1")
    public Queue queue1() {
        return QueueBuilder.durable(Queue1).deadLetterRoutingKey(Dead_Routing).deadLetterExchange(Dead_Exchange).build();
    }

    //    创建普通队列
    @Bean("Q2")
    public Queue queue2() {
        return QueueBuilder.durable(Queue2).deadLetterRoutingKey(Dead_Routing).deadLetterExchange(Dead_Exchange).build();
    }

    //    创建备份队列
    @Bean("WARN")
    public Queue WARN() {

        return QueueBuilder.durable(Warn_Queue).build();
    }

    //    创建备份队列

    @Bean("BACK")
    public Queue BACK() {
        return QueueBuilder.durable(backUp_Queue).build();

    }

    //    绑定普通交换机
    @Bean
    public Binding N_Nq1(@Qualifier("Exchange") DirectExchange directExchange, @Qualifier("Q1") Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with(Queue1_Key);
    }

    @Bean
    public Binding N_Nq2(@Qualifier("Exchange") DirectExchange directExchange, @Qualifier("Q2") Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with(Queue2_Key);
    }

    //    绑定备份交换机
    @Bean
    public Binding W_BQ(@Qualifier("backExchange") FanoutExchange fanoutExchange, @Qualifier("WARN") Queue queue) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding B_BQ(@Qualifier("backExchange") FanoutExchange fanoutExchange, @Qualifier("BACK") Queue queue) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    //    绑定死信
    @Bean
    public Binding DB(@Qualifier("DeadExchange") DirectExchange directExchange, @Qualifier("DeadQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with(Dead_Routing);
    }

}
