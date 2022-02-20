package com.example.seata_order.Service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

//标记为接收消息
public interface UpdateService {

    //    修改订单状态

    public void UpdateOrder(Message<String> message);
}
