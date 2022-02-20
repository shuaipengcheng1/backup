package com.misaka.data_model.Service;

import com.misaka.data_model.Dao.GoodsDao;
import com.misaka.data_model.Domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import java.util.Map;

@EnableBinding(Sink.class)

public class GoodsService {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    SendMessage sendMessage;
    @StreamListener(Sink.INPUT)
    public void String (Message<Map<String,Object>> message){
//        判断否有库存
        System.out.println(message.getPayload());
      Goods goods= goodsDao.findGoods((String) message.getPayload().get("info"));
     String id = (String) message.getPayload().get("id");
     System.out.println(id);
//      要购买的数量
      int num =1;

      if(goods.goods_num>num){
//
//          执行减少操作
         int i= goodsDao.Decrese(1);
         if(i>0){
//             成功减少后发送消息给消费者模块
                sendMessage.Send(goods.goods_price,id);
         }else {
             System.out.println("减少失败");
         }
      }else {
          System.out.println("无商品");
      }
    }
}
