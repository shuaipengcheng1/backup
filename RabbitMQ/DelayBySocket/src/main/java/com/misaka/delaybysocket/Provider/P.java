package com.misaka.delaybysocket.Provider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ttl")
public class P {
    @Autowired
    RabbitTemplate rabbitTemplate;
//    发送请求
    @RequestMapping("/send/{message}/{time}")
    public void Get(@PathVariable String message,@PathVariable Integer time){
        //"Delay.exchange"
        //"Delay.router"
        System.out.println("helloi");
//        发送消息
        rabbitTemplate.convertAndSend("Delay.exchange","Delay.router",message,(msg)->{
//            通过插件实现
            msg.getMessageProperties().setDelay(time);
            return msg;
        });
//        延迟

    }
}
