package com.misaka;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class rabbitProvider {
//    队列名称
    public static final String MQ_NAME="hello";
    //发信息
public static void main(String[] args) throws Exception {
//    创建一个链接工厂(rabbit提供的对象)
    ConnectionFactory connectionFactory = new ConnectionFactory();
    //链接rabbbitmq
    connectionFactory.setHost("192.168.194.128");
    connectionFactory.setUsername("misaka");
    connectionFactory.setPassword("spc652324");

//    创建链接(Connection对象也是rabbitMQ公司提供的)
 Connection connection= connectionFactory.newConnection();
// 每一个链接有多个信道
//    获取信道
   Channel channel= connection.createChannel();
   //创建一个队列
//    参数 (队列名称,是否需要持久化(消息是否持久化 默认存储在运行内存中),该队列是否只供一个消费者消费(如果true就允许 默认为false),是否自动删除,最后一个消费者开链接后 该队列是否自动删除 false为不自动删除,其他参数)
    channel.queueDeclare(MQ_NAME,false,false,false,null);
//    发送消息
    String message = "HELLO WORLD";
//    参数 (发送到哪一个交换机 表示信息要使用的队列的名称,其他参数,消息)
    channel.basicPublish("",MQ_NAME,null,message.getBytes());
//    测试lamba 通过lamba表达式 实例化接口的方法
    Test test =(var,var1)->{
        System.out.println(var+var1);
    };
    test.LambaTest("hello","test");

    System.out.println("发送完毕");

}
}
