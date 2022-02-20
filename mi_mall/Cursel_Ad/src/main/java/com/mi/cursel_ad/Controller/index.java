package com.mi.cursel_ad.Controller;

import com.mi.cursel_ad.Dao.CurselDao;
import com.mi.cursel_ad.Domain.Cursel;
import com.mi.cursel_ad.Service.CurselServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class index {
    @Autowired
    CurselServiceImpl curselService;
    @RequestMapping("/getCursel")
    public Map<String, List<Cursel>> get(){
   return      curselService.get();
    }
}
