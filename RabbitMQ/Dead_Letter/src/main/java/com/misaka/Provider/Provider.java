package com.misaka.Provider;

import com.misaka.Utill.Connection;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.MessageProperties;

import java.util.concurrent.ConcurrentSkipListMap;

public class Provider {
    public static void main(String[] args) throws Exception{
//        普通交换机的名称
        String ex = "normal_exchange";
        Channel channel = Connection .Get();
//        开启发布确认
        channel.confirmSelect();
//        设置一个容器
        ConcurrentSkipListMap concurrentSkipListMap =new ConcurrentSkipListMap();
        ConfirmCallback Ack=(messageTag,mutiple)->{
            System.out.println("成功"+messageTag);
            concurrentSkipListMap.remove(messageTag);

        };
        ConfirmCallback Err=(messageTag,mutiple)->{
            System.out.println("失败"+messageTag);
        };
//        添加一个监听器
        channel.addConfirmListener(Ack,Err);
//        设置过期时间
//        AMQP.BasicProperties basicProperties =new AMQP.BasicProperties().builder().expiration("10000").build();

        for (int i = 0; i <11 ; i++) {
//                                             设置消息过期时间
            channel.basicPublish(ex,"normal", MessageProperties.PERSISTENT_TEXT_PLAIN,new String("当前的消息"+i).getBytes());
        }

    }
}
