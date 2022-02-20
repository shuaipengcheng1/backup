package com.misaka.Consumer;

import com.misaka.Util.Connection;
import com.rabbitmq.client.Channel;

public class Dead_Consumer {
    public static void main(String[] args) throws Exception{
        Channel channel = Connection.GET();
        channel.basicConsume("d_q",true,(Tag,Message)->{
            System.out.println("死信"+new String(Message.getBody()));
        },(Tag)->{});
    }
}
