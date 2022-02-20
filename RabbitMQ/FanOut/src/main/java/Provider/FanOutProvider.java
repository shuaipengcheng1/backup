package Provider;

import Utill.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.MessageProperties;

import java.util.concurrent.ConcurrentSkipListMap;

public class FanOutProvider {
    //    发布者
    public static void main(String[] args) throws Exception {
        Channel channel = Connection.GetChannle();
//        异步发布确认
//        开启队列
        ConcurrentSkipListMap<Long,String> concurrentSkipListMap = new ConcurrentSkipListMap<>();

//        开启发布确认
        channel.confirmSelect();
//        开启监听器
        ConfirmCallback Ack=(Message,Mutiple)->{
//         删除
            concurrentSkipListMap.remove(Message);
        };
        ConfirmCallback Error=(Message,Mutiple)->{

        };
        channel.addConfirmListener(Ack,Error);
long start = System.currentTimeMillis();
//        发布消息
        for (int i = 1; i <=1000 ; i++) {
            String s = "当前为"+i;
            channel.basicPublish("FanOut","", MessageProperties.PERSISTENT_TEXT_PLAIN,s.getBytes());
        }
        long end = System.currentTimeMillis();

        System.out.println("耗时"+(start-end)+"ms");

    }
}
