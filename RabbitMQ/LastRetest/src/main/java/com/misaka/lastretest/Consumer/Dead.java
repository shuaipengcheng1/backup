package com.misaka.lastretest.Consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Dead {
    @RabbitListener(queues = "Dead_Queue")
    public void delay(Message message){
        System.out.println("死信"+new String(message.getBody()));
    }
}
