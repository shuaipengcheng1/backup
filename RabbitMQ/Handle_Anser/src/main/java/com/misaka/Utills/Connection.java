package com.misaka.Utills;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

public class Connection {
    public static Channel GetChannel() throws  Exception{
//        创建链接
        ConnectionFactory connectionFactory =new ConnectionFactory();
        connectionFactory.setUsername("misaka");
        connectionFactory.setPassword("spc652324");
        connectionFactory.setHost("192.168.194.128");
      com.rabbitmq.client.Connection connection= connectionFactory.newConnection();
    return   connection.createChannel();


    }
}
