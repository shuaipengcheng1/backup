package com.misaka.lastretest.Consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BackUp {
    @RabbitListener(queues = "WARN")
    public void W(Message message){
        System.out.println("备份交换机警告"+new String(message.getBody()));
    }
    @RabbitListener(queues = "BackUp")
    public void B(Message message){
        System.out.println("备份消息"+new String(message.getBody()));
    }
}
