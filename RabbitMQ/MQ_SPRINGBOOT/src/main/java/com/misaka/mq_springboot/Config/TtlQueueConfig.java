package com.misaka.mq_springboot.Config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TtlQueueConfig {
//    TTL队列 队列配置文件类的代码

    //    普通交换机的名称
    public String nor_exchange = "nor_exchange";
    //    死信交换机的名称
    public String dead_exchange = "dea_exchange";

    //    普通队列名称 分别延时10s 和 40s
    public String n_q1 = "norm_q1";
    public String n_q2 = "norm_q2";
    //    死信队列的名称
    public String d_q = "dea_q";
    //    两条队列的roterkey
    public String q1_r = "q1";
    public String q2_r = "q2";
    //    死信的routerkey 两个普通队列公用一台死信交换机 并且通过一个router发送死信
    public String d_roter = "d1";

    //    声明普通交换机
    @Bean("nor_exchange") //创建一个spring的对象 放入spring仓库 用于IOC
    public DirectExchange normal() {
        //声明交换机
        return new DirectExchange(nor_exchange);
    }

    //    声明死信交换机
    @Bean("dead_exchange")
    public DirectExchange dead() {
        return new DirectExchange(dead_exchange);
    }

    //    声明队列
    @Bean("n_q1")
    public Queue q1() {
//        开启持久化(该方法中传入的形参为队列名) 并且声明死信转发的交换机和存储死信息队列的路由 并且声明最大长度       ttl是延时
        return QueueBuilder.durable(n_q1).deadLetterExchange(dead_exchange).ttl(10000).deadLetterRoutingKey(d_roter).maxLength(6).build();
    }

    @Bean("n_q2")
    public Queue q2() {
        return QueueBuilder.durable(n_q2).deadLetterExchange(dead_exchange).deadLetterRoutingKey(d_roter).maxLength(6).ttl(40000).build();

    }

    //    声明死信队列
    @Bean("d_q1")
    public Queue d1() {
        return QueueBuilder.durable(d_q).build();
    }
//    普通交换机绑定普通队列 并且通过注入获取之前的两个普通队列
    @Bean
    public Binding q1AndNormalExchange(@Qualifier("n_q1") Queue q1,@Qualifier("n_q2") Queue q2,@Qualifier("nor_exchange") DirectExchange normalExchange){
//        绑定 xx队列 给 xx交换机 并且通过xx key
        return BindingBuilder.bind(q1).to(normalExchange).with(q1_r);
    }
    @Bean
    public Binding q2AndNormalExchange(@Qualifier("n_q1") Queue q1,@Qualifier("n_q2") Queue q2,@Qualifier("nor_exchange") DirectExchange normalExchange){
//        绑定 xx队列 给 xx交换机 并且通过xx key
        return BindingBuilder.bind(q2).to(normalExchange).with(q2_r);
    }
//    绑定死信交换机 和 死信队列
    @Bean
    public Binding DeadAndDeadExchange(@Qualifier("d_q1") Queue d_queue,@Qualifier("dead_exchange") DirectExchange dead){
        return BindingBuilder.bind(d_queue).to(dead).with(d_roter);
    }
    String N_q3 = "N_q3";
    String q3_r ="q3";
//   声明一个队列
    @Bean("Q3")
    public Queue Q3(){
//        不声明ttl过期时长
        return QueueBuilder.durable(N_q3).deadLetterRoutingKey(d_roter).deadLetterExchange(dead_exchange).build();
    }
//    绑定到交换机
    @Bean
    public Binding Q3Andex(@Qualifier("Q3") Queue q3,@Qualifier("nor_exchange") DirectExchange exchange){
        return BindingBuilder.bind(q3).to(exchange).with(q3_r);
    }



}
