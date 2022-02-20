package com.misaka.InterFace;

import com.misaka.Domain.Pay;

public interface PayService {
//    该接口为服务类接口

//    查找订单
    public Pay GetDeatil(int id);
//    创建订单
    public Boolean Create(String Detail);
}
