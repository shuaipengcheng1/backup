package com.day4.c.Config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
//    轮询原理  访问次数%总服务数 = 要轮询的下标
@Component
public class MylbImpl implements Mylb {
    //    设置原子数
    AtomicInteger atomicInteger = new AtomicInteger(0);

    //    访问次数获取
    public int GetNum() {
//        当前次数
        int count;
//        下一个次数
        int next;
        do {
            count = atomicInteger.get();
            next = count > 210000000 ? 0 : count+1;
//            compareAndSet(当前值,期望值) 如果atomic的值等于当前值 就会更新为期望值 否则不更新 这也叫做 CAS
        } while (!atomicInteger.compareAndSet(count, next));
        System.out.println("第" + count + "次访问");
        return next;
    }

    @Override
    public ServiceInstance GetService(List<ServiceInstance> serviceInstances) {
//        获取大小
        int s = serviceInstances.size();
        if (s > 0) {
            int next = GetNum();
            int index = next % s;
//      轮询
            return serviceInstances.get(index);
        }

        return null;
    }
}
