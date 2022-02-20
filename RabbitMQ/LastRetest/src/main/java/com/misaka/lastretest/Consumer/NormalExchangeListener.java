package com.misaka.lastretest.Consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.channels.Channel;

@Component
public class NormalExchangeListener {


//    监听普通交换机的所有队列
    @RabbitListener(queues = "Queue1")
    public void Q1(Message message){

        System.out.println("这是Queue1的消息"+new String(message.getBody()));

    }
    @RabbitListener(queues = "Queue2")
    public void Q2(Message message){
        System.out.println("这是Queue2的消息"+new String(message.getBody()));
    }

}
