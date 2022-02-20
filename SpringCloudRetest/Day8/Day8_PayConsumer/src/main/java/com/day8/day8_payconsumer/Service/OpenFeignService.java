package com.day8.day8_payconsumer.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//并且设置接口实现类 作为fallback方法
@FeignClient(value = "PAY",fallback = OpenFeignServiceImpl.class)
@Component
public interface OpenFeignService {
    //    openFeign业务接口
    @RequestMapping("/pay/{id}")
    public String pay(@PathVariable("id") int id);
}
