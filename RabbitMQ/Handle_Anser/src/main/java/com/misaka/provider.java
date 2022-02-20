package com.misaka;

import com.misaka.Utills.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

public class provider {
    private static String MQ_NAME="hello";
    //    提供者
    public static void main(String[] args) throws Exception {
//    创建链接
       Channel channel= Connection.GetChannel();
//       创建队列
        channel.queueDeclare(MQ_NAME,true,false,false,null);
//        传入消息
        String message = "hello world";
        channel.basicPublish("",MQ_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes("UTF-8"));
        System.out.println("消息发送");

    }
}
