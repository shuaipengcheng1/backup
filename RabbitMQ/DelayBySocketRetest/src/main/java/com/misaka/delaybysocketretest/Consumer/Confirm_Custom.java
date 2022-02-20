package com.misaka.delaybysocketretest.Consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Confirm_Custom {
    @RabbitListener(queues = "confirm.queue")
    public void Listen(Message message, Channel channel) throws Exception{
        System.out.println("外部"+new String(message.getBody()));
        channel.basicConsume("confirm.queue",false,(Tag,msg)->{
            System.out.println(new String(msg.getBody()));
//            应答
            channel.basicAck(msg.getEnvelope().getDeliveryTag(),false);
        },(Tag)->{
            System.out.println(Tag);
        });
    }
}
