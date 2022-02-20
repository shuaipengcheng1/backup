package com.misaka.lastretest.Config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Confirm implements RabbitTemplate.ConfirmCallback ,RabbitTemplate.ReturnCallback{
    @Autowired
    RabbitTemplate RabbitTemplate;
//    注入
    @PostConstruct
    public void init(){
        RabbitTemplate.setConfirmCallback(this);
        RabbitTemplate.setReturnCallback(this);
    }
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("退回的消息"+new String(message.getBody()));
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
if(b){
    System.out.println("消息已被交换机接收");
}else {
    System.out.println("消息没被交换机接收"+correlationData.getId());

}
    }
}
