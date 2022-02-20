package com.day5.ribbon_round_method.LoadBalanced;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLb {
//    获取一个服务器的方法
    ServiceInstance Round(List<ServiceInstance> serviceInstances);
}
