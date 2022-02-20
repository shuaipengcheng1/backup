package com.misaka.Provider;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Provider {
//    提供者 - 单个发布确认
public static void main(String[] args) throws  Exception {
//    队列名称
    String name ="h";
//    创建一个链接工厂
    ConnectionFactory connectionFactory =new ConnectionFactory();
    connectionFactory.setHost("192.168.194.128");
    connectionFactory.setPassword("spc652324");
    connectionFactory.setUsername("misaka");
//    创建链接
   Connection connection = connectionFactory.newConnection();
Channel channel= connection.createChannel();
// 创建持久化队列
    channel.queueDeclare(name,true,false,false,null);
//开启发布确认
    channel.confirmSelect();
//    发送一千条消息
    int MessageCount = 1000;
//    开始计时
  long Start=  System.currentTimeMillis();
    for (int i = 0; i < MessageCount; i++) {
//        发送
        channel.basicPublish("",name, MessageProperties.PERSISTENT_TEXT_PLAIN,new String("第"+i+"条").getBytes());
//        单个确认
        channel.waitForConfirms();
    }
//    结束计时
    long end = System.currentTimeMillis();
    System.out.println("花费"+(Start-end)+"ms");


}
}
