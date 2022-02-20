package com.misaka.Utill;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

public class Connection {
    public static Channel Get() throws Exception{
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.194.128");
        connectionFactory.setPassword("spc652324");
        connectionFactory.setUsername("misaka");
        return  connectionFactory.newConnection().createChannel();

    }
}
