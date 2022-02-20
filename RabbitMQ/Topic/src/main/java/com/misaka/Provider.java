package com.misaka;

import com.misaka.Utill.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.MessageProperties;

import java.util.concurrent.ConcurrentSkipListMap;

public class Provider {
    public static void main(String[] args) throws Exception {
        String MQ_NAME="h1";
//        获取队列
        Channel channel = Connection.getChannel();
        channel.queueDeclare(MQ_NAME,false,false,false,null);
//        开启发布确认
        channel.confirmSelect();
//        消息容器
        ConcurrentSkipListMap<Integer,String> concurrentSkipListMap = new ConcurrentSkipListMap();
//      监听
        ConfirmCallback AckCallback =(Tag,multiple)->{

//            删除对应的元素
            concurrentSkipListMap.remove(Tag);

        };
        ConfirmCallback Error=(Tag,multiple)->{
            System.out.println("失败");
        };
        channel.addConfirmListener(AckCallback,Error);
//        发布
        for (int i = 1; i <=1000 ; i++) {
            channel.basicPublish("Topic","h1", MessageProperties.PERSISTENT_TEXT_PLAIN,new String("第"+i+"条消息").getBytes());
        }
    }
}
