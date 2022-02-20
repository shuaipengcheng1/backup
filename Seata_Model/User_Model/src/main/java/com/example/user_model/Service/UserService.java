package com.example.user_model.Service;

import com.example.user_model.Dao.UserDao;
import com.example.user_model.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import java.util.Map;

@EnableBinding(Sink.class)
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    SendType sendType;

    @StreamListener(Sink.INPUT)
    public void Listen(Message<Map<String, Object>> message) {
        System.out.println("消息" + message.getPayload());
        User user = userDao.FindUser(1);
        if (user != null) {
            if (user.value >= (Integer) message.getPayload().get("price")) {
                int i = userDao.Decrease((Integer) message.getPayload().get("price"));

//  获取订单id
                String s = (String) message.getPayload().get("id");
                System.out.println("订单id" + s);
                if (i > 0) {
//    扣款成功 发送消息给订单系统 将其订单状态改为1
                    sendType.Change(s);
                }
            }
        }


    }
}
