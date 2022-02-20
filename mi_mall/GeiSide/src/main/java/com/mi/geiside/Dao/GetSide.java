package com.mi.geiside.Dao;

import com.mi.geiside.Domain.SideGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetSide {
//    获取手机
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
}
