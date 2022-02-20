package com.example.seata_order.Controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.seata_order.Domain.Order;
import com.example.seata_order.Service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @RequestMapping("/create/order")
    @SentinelResource(value = "CreateOrder", blockHandler = "orderFallback",fallback = "orderfallback")
    public String Create(@RequestParam(value = "info", required = true) String info) {
        Order order = new Order();
        order.order_info = info;
        order.id= UUID.randomUUID().toString();
        Boolean state = orderService.CreateOrder(order);
        if (state) {
            return "成功";
        } else {
            return "失败";

        }

    }

    public String orderFallback(String info, BlockException blockException) {
        return "不要访问那么快哦~";
    }
    public String orderfallback(){
        return "支付失败~";
    }
}
