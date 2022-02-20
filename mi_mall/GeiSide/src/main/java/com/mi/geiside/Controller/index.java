package com.mi.geiside.Controller;

import com.mi.geiside.Domain.SideGoods;
import com.mi.geiside.Service.GetSideServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class index {
    @Autowired
    GetSideServiceImpl sideService;
    @RequestMapping("/getSide")
    public Set<Map.Entry<String, List<SideGoods>>> getSide(){
//        转为数组给前端
        return  sideService.getSide().entrySet();
    }
}
