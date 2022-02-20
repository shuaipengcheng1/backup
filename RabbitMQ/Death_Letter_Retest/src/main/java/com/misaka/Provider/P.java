package com.misaka.Provider;

import com.misaka.Util.Connection;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.util.concurrent.ConcurrentSkipListMap;

public class P {
//    提供者
    static String EXCHANGE="n_exchange";
    static String ROUTER_NAME="n_router";
public static void main(String[] args) throws Exception{
//消息有限时长
    AMQP.BasicProperties basicProperties =new AMQP.BasicProperties().builder().expiration("10000").build();
    Channel channel = Connection.Get();
//    开启发布确认
    channel.confirmSelect();
// 消息容器
    ConcurrentSkipListMap skipListMap =new ConcurrentSkipListMap();
//    开启监听器
    channel.addConfirmListener((MessageTag,mutiple)->{
        System.out.println("消息成功");
        skipListMap.remove(MessageTag);
    },(MessageTag,mutiple)->{
        System.out.println("-");
    });
//    开始发布
    for (int i = 0; i <11 ; i++) {
        channel.basicPublish(EXCHANGE,ROUTER_NAME, basicProperties,new String("第"+i+"条消息").getBytes());
    }

}
}
