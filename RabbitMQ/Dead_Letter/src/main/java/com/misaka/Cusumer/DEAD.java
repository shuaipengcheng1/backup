package com.misaka.Cusumer;

import com.misaka.Utill.Connection;
import com.rabbitmq.client.Channel;

public class DEAD {
//    死信消费
public static void main(String[] args) throws Exception{
//    获取
    Channel channel = Connection.Get();
    channel.basicConsume("dead_queue",true,(tag,message)->{
        System.out.println("死信"+new String(message.getBody()));
    },(tag)->{});
}
}
