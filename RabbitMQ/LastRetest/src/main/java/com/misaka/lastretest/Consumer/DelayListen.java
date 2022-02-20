package com.misaka.lastretest.Consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DelayListen {
    @RabbitListener(queues = "DelayedQueue")
    public void delay(Message message){
        System.out.println("延时消息"+new String(message.getBody()));
    }
}
