package com.day12.stream_provider_day12.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@EnableBinding(Source.class)
@Component
public class PayServiceImpl implements PayService {
//    获取信道对象
    @Qualifier("output")
    @Autowired
    MessageChannel channel ;
    @Override
    public String Pay(int id) {
        Map<String,Object> map= new HashMap<>();
        map.put("id",id);
        channel.send(MessageBuilder.withPayload(map).build());
        return "订单";
    }
}
