package com.mi.cursel_ad.Service;

import com.mi.cursel_ad.Dao.CurselDao;
import com.mi.cursel_ad.Domain.Cursel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CurselServiceImpl implements CurselService {
    @Autowired
    CurselDao curselDao;

    @Override
    public Map<String, List<Cursel>> get() {
        Map<String, List<Cursel>> map = new HashMap<>();
        map.put("cursel", curselDao.getCursel());
        map.put("curselad", curselDao.getCurselAd());
        map.put("ad", curselDao.getAd());
        return map;
    }
}
