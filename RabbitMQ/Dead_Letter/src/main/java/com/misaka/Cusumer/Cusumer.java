package com.misaka.Cusumer;

import com.misaka.Utill.Connection;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.util.HashMap;
import java.util.Map;

public class Cusumer {
    //    普通队列
    public static String normal_queue = "normal_queue";
    //    死信队列
    public static String dead_queue = "dead_queue";

    //    死信交换机
    public static String dead_exchange = "dead_exchange";
    //    普通交换机
    public static String normal_exchange = "normal_exchange";


    public static void main(String[] args) throws Exception{
//      创建链接
        Channel channel = Connection.Get();
//        创建交换机
        channel.exchangeDeclare(normal_exchange, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(dead_exchange,BuiltinExchangeType.DIRECT);
        Map<String,Object> map =new HashMap<>();
        //        给普通的交换机设置 一个死信交换机 如果出现了死信的情况 则会将消息转发到指定的死信队列
//设置队列长度
        map.put("x-max-length",6);

//        设置死信交换机
        map.put("x-dead-letter-exchange",dead_exchange);
//        设置死信队列的路由key 到时候转发会使用这个key
        map.put("x-dead-letter-routing-key","dead");
//        声明普通队列 并且绑定死信队列
        channel.queueDeclare(normal_queue,true,false,false,map);
//        声明死信队列
        channel.queueDeclare(dead_queue,true,false,false,null);

//        交换机绑定队列         要绑定的队列      交换机       routerkey
        channel.queueBind(normal_queue,normal_exchange,"normal");
        channel.queueBind(dead_queue,dead_exchange,"dead");
//        监听普通消息   如果要将拒绝的消息传递给死信 那么就要把手动消息应答打开
        channel.basicConsume(normal_queue,false, (tag,message) -> {
            String s = new String(message.getBody());
            if(s.equals("当前的消息5")){
//                拒绝
                channel.basicReject(message.getEnvelope().getDeliveryTag(),false);
            }else {
                System.out.println(s);
//                应答
                channel.basicAck(message.getEnvelope().getDeliveryTag(),false);

            }
        }, CancelCallback->{});


    }
}
