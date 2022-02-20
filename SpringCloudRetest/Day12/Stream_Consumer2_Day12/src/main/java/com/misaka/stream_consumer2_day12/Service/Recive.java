package com.misaka.stream_consumer2_day12.Service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({Sink.class})
public class Recive {
    @StreamListener(Sink.INPUT)
    public void L(Message message){
        System.out.println("接收2"+message.getPayload());
    }
}
