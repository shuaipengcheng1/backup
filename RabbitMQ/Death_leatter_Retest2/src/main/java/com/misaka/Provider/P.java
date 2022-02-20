package com.misaka.Provider;

import com.misaka.Util.Connection;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;

import java.util.concurrent.ConcurrentSkipListMap;

public class P {
    public static String n_exchange ="n_e";
    public static String n_routerKey ="n";


    public static void main(String[] args) throws Exception{
        Channel channel = Connection.GET();
//        开启发布确认
        channel.confirmSelect();
//        定义一个容器
        ConcurrentSkipListMap skipListMap =new ConcurrentSkipListMap();
//        添加一个监听器
        channel.addConfirmListener((Message,Multiple)->{
            System.out.println("发布成功");
            skipListMap.remove(Message);
        },(Message,Multiple)->{
//失败回调
        });
//        消息过期时长
        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder().expiration("10000").build();
//        发布
        for (int i = 0; i <10 ; i++) {
            channel.basicPublish(n_exchange,n_routerKey,basicProperties,new String("第"+i+"条消息").getBytes());
        }

    }

}
