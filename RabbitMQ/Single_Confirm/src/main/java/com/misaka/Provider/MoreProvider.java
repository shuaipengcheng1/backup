package com.misaka.Provider;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class MoreProvider {
//    批量发送
public static void main(String[] args) throws Exception {
    String name = "test";
    ConnectionFactory connectionFactory =new ConnectionFactory();
    connectionFactory.setUsername("misaka");
    connectionFactory.setPassword("spc652324");
    connectionFactory.setHost("192.168.194.128");
   Connection connection= connectionFactory.newConnection();
//    创建频道
   Channel channel= connection.createChannel();
//  队列
   channel.queueDeclare(name,true,false,false,null);
//开起发布确认
    channel.confirmSelect();

    int ChannelCount = 1000;
//    开始计时
    long time = System.currentTimeMillis();
//    批量发布
    for (int i = 1; i <= ChannelCount; i++) {
//        发布
        channel.basicPublish("",name, MessageProperties.PERSISTENT_TEXT_PLAIN,new String("第"+i+"条").getBytes());
//每一百条确认1次
        if(i%100==0){
//            确认发布
            channel.waitForConfirms();
        }
    }
    long end = System.currentTimeMillis();
    System.out.println("共"+(time-end)+"ms"); //175

}
}
