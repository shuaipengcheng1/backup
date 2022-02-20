package com.misaka.mq_springboot.Controller;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ttl")

public class SeedMsgController {
//    获取 发布者方法
    @Autowired
    RabbitTemplate rabbitTemplate;


//    发送延迟消息
//    以后发消息都是通过http请求来实现动态发送的 前端携带参数请求
//    后端通过在接口函数体中 调用RabbitTemplate对象的converAndSend方法来发送消息
@GetMapping(value = "/send/{message}")
    public void Send(@PathVariable("message") String message){
//    发送消息
    rabbitTemplate.convertAndSend("nor_exchange","q1",message);
    rabbitTemplate.convertAndSend("nor_exchange","q2",message);

}

//发送自定义延迟时间消息给消费者
    @GetMapping("/self/{message}/{ttl}")
    //http://localhost:8081/ttl/self/test/5000    发送test 延时5000ms
    public void S(@PathVariable("message") String message,@PathVariable("ttl") String ttl){
//        发送消息
        rabbitTemplate.convertAndSend("nor_exchange","q3",message, (message1)->{
//            设置时长
            message1.getMessageProperties().setExpiration(ttl);
            return message1;
        });
    }
}
