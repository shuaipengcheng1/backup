package com.misaka.Util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

public class Connection {
    public static Channel Get() throws Exception{
        ConnectionFactory connectionFactory =new ConnectionFactory();
        connectionFactory.setUsername("misaka");
        connectionFactory.setPassword("spc652324");
        connectionFactory.setHost("192.168.194.128");
       return connectionFactory.newConnection().createChannel();

    }
}
