package com.mi.cursel_ad.Dao;

import com.mi.cursel_ad.Domain.Cursel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CurselDao {
//    获取轮播图
   public List<Cursel> getCursel();
//    获取轮播图下面广告
public List<Cursel> getCurselAd();

//    获取广告
public List<Cursel> getAd();

}
