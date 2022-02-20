package com.example.seata_order.Dao;

import com.example.seata_order.Domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
//    创建订单
 public int CreateOrder(Order order);

//    修改订单状态
    public int UpdateOrder(int type,String Orderid);
}
