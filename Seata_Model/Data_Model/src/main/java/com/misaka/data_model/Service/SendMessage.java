package com.misaka.data_model.Service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@EnableBinding({Source.class})
@Component
public class SendMessage {
    //    发送信息给用户 进行扣款操作
    @Autowired
    @Qualifier("output")
    MessageChannel messageChannel;

    public Boolean Send(int Price,String id) {
        Map map=new HashMap();
        map.put("price",Price);
        map.put("id",id);
        Boolean b = messageChannel.send(MessageBuilder.withPayload(map).build());
        return b;
    }
}
