package com.misaka.Utill;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitConnection {
   public Channel getChannel() throws Exception{
//        配置链接
       ConnectionFactory connectionFactory = new ConnectionFactory();
       connectionFactory.setHost("192.168.194.128");
       connectionFactory.setPassword("spc652324");
       connectionFactory.setUsername("misaka");
//       获取链接
      Connection  connection= connectionFactory.newConnection();
//      创建信道
      Channel channel= connection.createChannel();
       return  channel;
    }
}
