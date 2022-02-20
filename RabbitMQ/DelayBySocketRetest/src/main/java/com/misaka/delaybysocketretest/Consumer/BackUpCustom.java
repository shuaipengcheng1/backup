package com.misaka.delaybysocketretest.Consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class BackUpCustom {
    @RabbitListener(queues = "BackUpQueue")
    public void g(Message message){
        System.out.println("备份消息"+new String(message.getBody()));

    }
    @RabbitListener(queues = "WarnQueue")
    public void w(Message message){
        System.out.println("警报消息"+new String(message.getBody()));

    }
}

