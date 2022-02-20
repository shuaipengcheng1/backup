package com.example.seata_order.Service;

import com.example.seata_order.Domain.Order;
import com.sun.org.apache.xpath.internal.operations.Bool;

public interface OrderService {
    //    创建订单
    public Boolean CreateOrder(Order order);


}
