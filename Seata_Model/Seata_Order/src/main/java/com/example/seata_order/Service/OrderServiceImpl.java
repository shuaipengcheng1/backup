package com.example.seata_order.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.seata_order.Dao.OrderDao;
import com.example.seata_order.Domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
////标记为stream发送管道
@EnableBinding(Source.class)
public class OrderServiceImpl implements OrderService {
    @Qualifier("output")
    @Autowired
    MessageChannel messageChannel;
    @Autowired
    OrderDao orderDao;
    @Override
    public Boolean CreateOrder(Order order) {
        int state = orderDao.CreateOrder(order);
        if (state > 0) {
            Map map = new HashMap();
            map.put("info", order.order_info);
//            发送订单状态
            map.put("state", 0);
//            发送订单id
            map.put("id",order.id);
//            发送消息 给库存服务
          Boolean s = messageChannel.send(MessageBuilder.withPayload(map).build());

            return true;
        }else
        return false;

    }


}
