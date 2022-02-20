package com.day13.consumer_day13.Feign;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@EnableBinding({Sink.class})
@Component
public class Stream {
    @StreamListener(Sink.INPUT)
    public void sink(Message message){
        System.out.println("消息接收"+message.getPayload());
    }
}
