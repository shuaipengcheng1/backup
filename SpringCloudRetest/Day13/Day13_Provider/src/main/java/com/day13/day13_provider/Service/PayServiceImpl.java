package com.day13.day13_provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
//开启stream管道 通过rabbitmq发送消息
@EnableBinding(Source.class)
public class PayServiceImpl implements PayService {
    @Qualifier("output")
    @Autowired
    MessageChannel messageChannel;
    @Override
    public String pay(int id) {
        Map map =new HashMap();
        map.put("id",id);
//        发送消息
    Boolean b=   messageChannel.send(MessageBuilder.withPayload(map).build());
    if(b){
        return "true";
    }else
        return "false";
    }
}
