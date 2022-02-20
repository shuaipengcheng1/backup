package com.misaka.nacos_consumer.OpenFeign;

public class FeignServiceImpl implements FeignService {
    @Override
    public String p(int id) {
        return "客户端出错";
    }
}
