package com.misaka.Cusumer;

import com.rabbitmq.client.*;

public class AsyncCustom {
//    消费之
public static void main(String[] args) throws Exception {
//    链接
    String MQ_NAME = "t";
    ConnectionFactory connectionFactory = new ConnectionFactory();
    connectionFactory.setPassword("spc652324");
    connectionFactory.setHost("192.168.194.128");
    connectionFactory.setUsername("misaka");
  Connection connection = connectionFactory.newConnection();
 Channel channel= connection.createChannel();
    DeliverCallback deliverCallback=(MessageTag,Message)->{
//
        System.out.println(new String(Message.getBody()));
//        确认
        channel.basicAck(Message.getEnvelope().getDeliveryTag(),false);
    };
    CancelCallback cancelCallback =(MessageTag)->{

    };
// 接收消息
    channel.basicConsume(MQ_NAME,false,deliverCallback,cancelCallback);

}
}
