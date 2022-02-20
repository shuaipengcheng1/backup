package com.misaka.mq_springboot.Consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DeadletterConsumer {
//    接收延迟消息的消费者
    @RabbitListener(queues = "dea_q")
    public void Recive(Message message, Channel channel){
//        获取消息
        String s = new String(message.getBody());
        try {
            channel.basicConsume("dea_q",false,(Tag,Message)->{
           System.out.println(              "死信"+   new String(Message.getBody())
);
           channel.basicAck(Message.getEnvelope().getDeliveryTag(),false);
            },(t)->{});
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("死信"+s);
    }
//    监听普通队列
    @RabbitListener(queues = "norm_q1")
    public void Normal(Message message,Channel channel){
        String s = new String(message.getBody());

        try {
            channel.basicConsume("dea_q",false,(Tag,Message)->{
                System.out.println(              "普通"+   new String(Message.getBody())
                );
                channel.basicAck(Message.getEnvelope().getDeliveryTag(),false);

            },(t)->{});
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("普通"+s);

    }
}
