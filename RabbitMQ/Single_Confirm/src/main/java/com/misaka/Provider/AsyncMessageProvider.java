package com.misaka.Provider;

import com.rabbitmq.client.*;

import java.util.concurrent.ConcurrentSkipListMap;

public class AsyncMessageProvider {
    public static String MQ_NAME = "t";

    //    异步发布
    public static void main(String[] args) throws Exception {
//    获取链接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.194.128");
        connectionFactory.setUsername("misaka");
        connectionFactory.setPassword("spc652324");
        //    获取链接对象

        Connection connection = connectionFactory.newConnection();
//    获取信道对象
        Channel channel = connection.createChannel();
//  开启发布确认
        channel.confirmSelect();
//    创建队列
        channel.queueDeclare(MQ_NAME, true, false, false, null);
//创建一个高并法的哈希表
        ConcurrentSkipListMap<Long,Object> concurrentSkipListMap = new ConcurrentSkipListMap<>();
//    准备一个监听器 通过监听器来判断 那些消息成功 那些消息失败

//失败的监听
        ConfirmCallback NackCallback = (deliveryTag, multiple) -> {
            System.out.println("未确认的消息" + deliveryTag);

        };
//    成功
        ConfirmCallback ACKCallback = (deliveryTag, multiple) -> {
//           删除对应编号的数据
            concurrentSkipListMap.remove(deliveryTag);
        };
//开启监听 这一个函数是在Broker(队列容器)的地方实现的 而不是Provider的位置实现的
//        例如 Broker接收到了消息 然后调用 channel.waitForConfirms() 来发布确认
//        此时就会调用这边的监听器的成功回调 从而实现异步操作
        channel.addConfirmListener(ACKCallback, NackCallback);
        int message_Count = 1000;
        long Start = System.currentTimeMillis();
//    发送消息
        for (int i = 0; i <= message_Count; i++) {
//        消息开启持久化
            channel.basicPublish("", MQ_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, new String("第" + i + "条信息").getBytes());

//       将所有的消息存储起来
            concurrentSkipListMap.put((long) i,new String("第" + i + "条信息"));
        }
        long end = System.currentTimeMillis();
        System.out.println("共耗时"+(Start-end)+"ms");

    }
}
