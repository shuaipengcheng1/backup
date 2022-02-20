package com.misaka;

import com.misaka.Utill.Connection;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class Costom {
//    消费者 1  队列名 h1

public static void main(String[] args) throws Exception{
    String MQ_NAME="h1";
//     获取channel
  Channel channel = Connection.getChannel();
// 链接队列
    channel.queueDeclare(MQ_NAME,false,false,false,null);
// 获取数据
    DeliverCallback deliverCallback =(Tag,Message)->{
        System.out.println(new String(Message.getBody()));
//        应答  批量应答
        channel.basicAck(Message.getEnvelope().getDeliveryTag(),false);

    };
    CancelCallback cancelCallback =(message)->{
        System.out.println(message);
    };
    channel.basicConsume(MQ_NAME,false,deliverCallback,cancelCallback);

}
}
