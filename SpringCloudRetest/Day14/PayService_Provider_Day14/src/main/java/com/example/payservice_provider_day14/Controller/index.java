package com.example.payservice_provider_day14.Controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.payservice_provider_day14.MyHandler.StringHandler;
import com.example.payservice_provider_day14.Service.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class index {
    @Autowired
    PayServiceImpl payService;

    @RequestMapping("/pay/{id}")
    public String i(@PathVariable("id") int id) {
        return payService.pay(id);
    }

    @RequestMapping("/test")
    public String t() {
        return "t";
    }

    @RequestMapping("/fallback/timeout")
    public String timeOut() throws Exception {
//        设置一个可以触发超时阈值的睡眠 来模拟复杂的业务场景

        System.out.println("睡眠");
        Thread.sleep(3000);
        return "timeout ok";


    }
    @RequestMapping("/fallback/ErrorPercent/{id}")
    public String p(@PathVariable("id") int id){
        if(id>0){
            return "id";
        }else{
            int a =10/0;
            throw new RuntimeException("错误");
        }
    }
    @RequestMapping("/fallback/ErrorNum")
    public String Num(){
        int a=10/0;
        return "string";
    }

    @RequestMapping("/hotKey")
//    设置blockHandler
    @SentinelResource(value = "hotKey",blockHandler = "deal_Hotkey")
    public String get(@RequestParam(value = "p1",required = false) String p1){
        System.out.println(p1);
        return p1;
    }
//处理sentinel错误
    public String deal_Hotkey(String p1, BlockException  blockException){
        return  "兜底";
    }

    @RequestMapping("/fallback/self")
    @SentinelResource(value = "fallbackself",fallback = "fallback")
    public String s(){
        int a=10/0;
        return "x";
    }
//    处理java错误
    public String fallback(){
        return "fallback self";
    }

    @RequestMapping("/fallback/g")
    @SentinelResource(value = "string",blockHandlerClass = StringHandler.class,blockHandler = "s")
    public String string(){
        return "s";
    }

}
