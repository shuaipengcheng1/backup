package com.day4.c.Config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface Mylb {
//    获取服务
    ServiceInstance GetService(List<ServiceInstance> serviceInstances);
}
