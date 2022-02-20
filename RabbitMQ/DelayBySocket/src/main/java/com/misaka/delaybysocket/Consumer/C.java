package com.misaka.delaybysocket.Consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.channels.Channel;

@Component
public class C {
//    @RabbitListener(queues = "d_queue_Socket")
//    public void get(Message message, Channel channel){
//        System.out.println(new String(message.getBody()));
//    }
    @RabbitListener(queues = "Delay.Queue")
    public void get1(Message message){
        System.out.println(new String(message.getBody()));
    }
}
