package com.misaka.Custom;

import com.misaka.Utills.Connection;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class Custom2 {
    //    消费者二号
    public static String MQ_NAME = "hello";

    public static void main(String[] args) throws Exception {
//    创建链接
      Channel channel= Connection.GetChannel();
      System.out.println("较慢");
        channel.basicQos(1);
//        线程睡眠 模拟处理时长
Thread.sleep(10000);
        DeliverCallback deliverCallback=(CusumerTag,Message)->{
            System.out.println(new String(Message.getBody()));
            try {
//                休眠
                Thread.sleep(10000);
                //            应答
                channel.basicAck(Message.getEnvelope().getDeliveryTag(),false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        CancelCallback cancelCallback = (Cusumer)->{
            System.out.println(Cusumer);
        };
//      创建队列
        channel.basicConsume(MQ_NAME,false,deliverCallback,cancelCallback);
    }
}
