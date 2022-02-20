package com.day5.ribbon_round_method.LoadBalanced;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLbImpl implements MyLb {
    //    创建一个高并发的liST数据列表 也就是CAS
    AtomicInteger atomicInteger = new AtomicInteger(0);

    //    轮询算法 请求次数%服务器长度 = 服务器下标
    public int RequestNum() {
        int count;
        int next;

//        cas 自旋锁
        do {

            count = atomicInteger.get();
            next = count > 2100000000 ? 0 : count + 1;

        } while (!atomicInteger.compareAndSet(count, next));
        return atomicInteger.get();
    }

    @Override
    public ServiceInstance Round(List<ServiceInstance> serviceInstances) {
//        判断服务器长度
        if (serviceInstances.size() != 0) {
//   获取下标
            int index = RequestNum() % serviceInstances.size();
//            获取服务器
            return serviceInstances.get(index);
        }
        return null;
    }
}
