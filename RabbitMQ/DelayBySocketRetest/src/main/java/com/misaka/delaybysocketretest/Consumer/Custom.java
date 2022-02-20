package com.misaka.delaybysocketretest.Consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.channels.Channel;

@Component
public class Custom {
    @RabbitListener(queues = "Retest_Queue")
    public void listen(Message message){
        System.out.println(new String(message.getBody()));

    }
}
