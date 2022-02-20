package com.misaka;

import com.rabbitmq.client.*;

public class rabbitCustom {
//    消费者

//    要接受队列的名称
    public static String MQ_NAME="hello";

    public static void main(String[] args) throws Exception {
//        创建一个链接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setPassword("spc652324");
        connectionFactory.setUsername("misaka");
        connectionFactory.setHost("192.168.194.128");
//        创建链接
      Connection connection= connectionFactory.newConnection();
//      创建信道
       Channel channel= connection.createChannel();
//       通过信道接收消息
//        声明接收的回调
        DeliverCallback deliverCallback = (consumerTag,message)->{
//            获取与
System.out.println(new String(message.getBody()));
        };
//        拒绝的回调 lamba表达式
        CancelCallback cancelCallback = consumerTag->{
            System.out.println("消息中断");
        };
//        接收参数 (要接收消息的列表名,是否自动答，接收会调用的回调函数，拒绝的回调)
        channel.basicConsume(MQ_NAME,true,deliverCallback,cancelCallback);

    }
}
