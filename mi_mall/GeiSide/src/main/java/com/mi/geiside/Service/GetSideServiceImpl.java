package com.mi.geiside.Service;

import com.mi.geiside.Dao.GetSide;
import com.mi.geiside.Domain.SideGoods;
import org.apache.commons.collections.map.ListOrderedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GetSideServiceImpl implements GetSideService {

    /*
    * //    获取手机
    List<SideGoods> getPhone();
    //    获取电视
    List<SideGoods> getTv();
    //    获取笔记本 平板
    List<SideGoods> getLapTopPad();
    //    获取家电
    List<SideGoods> getJiaDian();
    //    获取智能路由器
    List<SideGoods> getAiRouter();
    //    获取电源配件
    List<SideGoods> getBattery();
    //    获取健康儿童
    List<SideGoods> getHealthChildren();
    //    获取耳机 音响
    List<SideGoods> getEarPhone();
    //    获取生活箱包
    List<SideGoods> getLiveBag();
    //    获取出行穿戴
    List<SideGoods> getOutSideWear();
    * */
    @Autowired
    GetSide getSide;

    @Override
    public Map<String, List<SideGoods>> getSide() {
//        有序输出
        Map<String, List<SideGoods>> result = new ListOrderedMap();

        result.put("手机", getSide.getPhone());
        result.put("电视", getSide.getTv());
        result.put("笔记本 平板", getSide.getLapTopPad());
        result.put("笔电", getSide.getJiaDian());
        result.put("出行 穿戴", getSide.getOutSideWear());
        result.put("智能 路由器", getSide.getAiRouter());
        result.put("电源 配件", getSide.getBattery());
        result.put("健康", getSide.getHealthChildren());
        result.put("耳机 音箱", getSide.getEarPhone());
        result.put("生活 箱包", getSide.getLiveBag());

       return  result;





    }
}
