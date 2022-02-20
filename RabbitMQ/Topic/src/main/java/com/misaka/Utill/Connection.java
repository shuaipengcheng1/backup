package com.misaka.Utill;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Connection {
    //    链接工具类
    public static Channel getChannel() {
        Channel channel = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setPassword("spc652324");
        connectionFactory.setUsername("misaka");
        connectionFactory.setHost("192.168.194.128");
        try {
            com.rabbitmq.client.Connection connection = connectionFactory.newConnection();
            channel = connection.createChannel();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return channel;
    }
}
