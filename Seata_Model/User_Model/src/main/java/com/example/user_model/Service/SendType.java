package com.example.user_model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class SendType {
    @Autowired
    @Qualifier("output")
    MessageChannel messageChannel;

    public  void Change (String Order_id){
//        通过订单id 修改订单状态
        messageChannel.send(MessageBuilder.withPayload(Order_id).build());
    }
}
