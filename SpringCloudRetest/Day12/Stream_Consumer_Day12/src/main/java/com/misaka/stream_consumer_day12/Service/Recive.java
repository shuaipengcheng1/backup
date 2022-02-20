package com.misaka.stream_consumer_day12.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class Recive {
    @StreamListener(Sink.INPUT)
    public void S(Message message){
        System.out.println("接收消息"+message.getPayload());
    }
}
