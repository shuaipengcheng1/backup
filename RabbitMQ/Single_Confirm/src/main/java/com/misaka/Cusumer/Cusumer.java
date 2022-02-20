package com.misaka.Cusumer;

import com.rabbitmq.client.*;

public class Cusumer {
    public static void main(String[] args) throws Exception {
        //    队列名称
        String name = "h";
//    创建一个链接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.194.128");
        connectionFactory.setPassword("spc652324");
        connectionFactory.setUsername("misaka");
//    创建链接
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
//        创建队列
        channel.queueDeclare(name, true, false, false, null);
//        回调函数
        DeliverCallback deliverCallback = (messageTag, Message) -> {
//            获取消息
            System.out.println(new String(Message.getBody()));
//    答复                                消息标记                      不批量答复
            channel.basicAck(Message.getEnvelope().getDeliveryTag(), false);
        };
        CancelCallback cancelCallback =(Message)->{
            System.out.println(Message);
        };
//        通过队列接收消息
//         关闭自动答复
        channel.basicConsume(name, false,deliverCallback, cancelCallback);

    }
}
