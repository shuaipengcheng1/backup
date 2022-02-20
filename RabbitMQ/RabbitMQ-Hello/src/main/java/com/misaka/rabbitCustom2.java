package com.misaka;

import com.misaka.Utill.RabbitConnection;
import com.rabbitmq.client.*;

public class rabbitCustom2 {
    //    要接受队列的名称
    public static String MQ_NAME = "hello";

    public static void main(String[] args) throws Exception {
        RabbitConnection rabbitConnection =new RabbitConnection();
   Channel   channel=  rabbitConnection.getChannel();
//       通过信道接收消息
//        声明接收的回调
        DeliverCallback deliverCallback = (consumerTag, message) -> {
//            获取与
            System.out.println(new String(message.getBody()));
        };
//        拒绝的回调 lamba表达式
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("消息中断");
        };
//        接收参数 (列表名,是否自动答，接收会调用的回调函数，拒绝的回调)
        channel.basicConsume(MQ_NAME, true, deliverCallback, cancelCallback);
    }
}
