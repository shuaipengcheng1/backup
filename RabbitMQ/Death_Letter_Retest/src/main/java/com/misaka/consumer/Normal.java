package com.misaka.consumer;

import com.misaka.Util.Connection;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.util.HashMap;
import java.util.Map;

public class Normal {
//    普通消费者

    //    普通队列
    static String normal = "n_queue";
    //    死信队列
    static String Dead = "d_queue";
    //    普通交换机
    static String normal_ex = "n_exchange";
    //    死信交换机
    static String Dead_ex = "d_exchange";
    //    普通路由
    static String n_router = "n_router";
    //    死信路由
    static String d_router = "d_router";


    public static void main(String[] args) throws Exception {
//        获取信道
        Channel channel = Connection.Get();
//        创建交换机
        channel.exchangeDeclare(normal_ex, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(Dead_ex, BuiltinExchangeType.DIRECT);


//        设置死信
        Map map = new HashMap();
        map.put("x-max-length", 6);
        map.put("x-dead-letter-exchange", Dead_ex);
        map.put("x-dead-letter-routing-key", d_router);
//        声明队列
        channel.queueDeclare(normal, true, false, false, map);
//        声明死信队列
        channel.queueDeclare(Dead, true, false, false, null);
        //    绑定交换机与队列
        channel.queueBind(normal, normal_ex, n_router);
        channel.queueBind(Dead, Dead_ex, d_router);
//        开启接收器
        channel.basicConsume(normal, false, (Tag, Message) -> {
            String s = new String(Message.getBody());
            if (s.equals("第5条消息")) {
//                拒绝
                channel.basicReject(Message.getEnvelope().getDeliveryTag(), false);
            } else {
                System.out.println("消息" + new String(Message.getBody()));
//            确定
                channel.basicAck(Message.getEnvelope().getDeliveryTag(), false);
            }

        }, Tag -> {
        });

    }

}
