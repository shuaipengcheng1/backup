package com.misaka.Custom;

import com.misaka.Utills.Connection;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

public class Custom1 {
//    消费者 手动应答
    static String  MQ_NAME="hello";
public static void main(String[] args) throws  Exception {
//   创建链接
  Channel channel= Connection.GetChannel();
  channel.basicQos(1);
    DeliverCallback delivery =(CusumerTag,Message)->{
//        获取消息
        System.out.println(new String(Message.getBody()));
   // 手动应答
        channel.basicAck(Message.getEnvelope().getDeliveryTag(),false);
        System.out.println("消息接收成功");
    };
    CancelCallback cancelCallback = (var1)->{
        System.out.println(var1);
    };
//  链接消息队列
    channel.basicConsume(MQ_NAME,false,delivery,cancelCallback);
}
}
