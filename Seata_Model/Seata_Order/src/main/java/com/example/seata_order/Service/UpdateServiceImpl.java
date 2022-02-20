package com.example.seata_order.Service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.seata_order.Dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@EnableBinding({Sink.class})
public class UpdateServiceImpl implements UpdateService {
    @Autowired
    OrderDao orderDao;

    @StreamListener(Sink.INPUT)
    @Override

    public void UpdateOrder(Message<String> message) {
        System.out.println("订单端接收的消息" + message.getPayload());
//
        orderDao.UpdateOrder(1, message.getPayload());

        System.out.println("订单支付完毕");

    }

}
