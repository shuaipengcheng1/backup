package com.misaka.consumer;

import com.misaka.Util.Connection;
import com.rabbitmq.client.Channel;

public class Dead {
    public static void main(String[] args) throws Exception{
        Channel channel = Connection.Get();
        channel.basicConsume("d_queue",true,(Tag,Message)->{
            System.out.println("死信"+new String(Message.getBody()));
        },(Tag)->{});
    }
}
