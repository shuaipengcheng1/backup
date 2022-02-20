package com.misaka.delaybysocketretest.Confirm;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConfirmCallBack implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int replycode, String replaytxt, String exchange, String routingkey) {
        System.out.println("失败的消息"+new String(message.getBody())+"原因"+replaytxt+"交换机"+exchange+"路由"+routingkey);
    }

    @Autowired
   RabbitTemplate rabbitTemplate;
//   注入到方法接口中
    @PostConstruct
    public void init(){
      rabbitTemplate.setConfirmCallback(this);
      rabbitTemplate.setReturnCallback(this);
    }



    /*
    * CorrelationData 保存回调消息的ID及相关信息
    * 布尔值    交换机是否接收
    * String   失败的原因
    * */

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if(b){
//            发送成功
            System.out.println("发送成功");
        }else {
            System.out.println(correlationData.toString()+"失败"+"id"+correlationData.getId());
        }
    }
}
