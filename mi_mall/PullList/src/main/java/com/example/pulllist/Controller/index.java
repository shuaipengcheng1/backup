package com.example.pulllist.Controller;

import com.example.pulllist.Domain.PullItem;
import com.example.pulllist.Service.PullServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class index {
    @Autowired
    PullServiceImpl pullService;
    @RequestMapping("/getPull")
    public List<PullItem> pullItems (@RequestParam("type") String type){
        return pullService.pull(type);
    }
}
