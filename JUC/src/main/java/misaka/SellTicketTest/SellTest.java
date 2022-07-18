package misaka.SellTicketTest;

import java.util.List;
import java.util.Vector;

public class SellTest {
    //    售卖
    public static void main(String[] args) {
//    100000张票 共享数据 不安全
        SellWindows sellWindows = new SellWindows(10000000);
//    卖出的票
        List<Integer> list = new Vector<>();
//        线程列表
        List<Thread> threads = new Vector<>();
//    创建10000条并行线程 都买票
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() -> {
                int n = sellWindows.Sell(1000);
                list.add(n);
            }, "t" + i);
            threads.add(thread);
            thread.start();
        }
        for (Thread t:threads
             ) {
            try {
//                等待所有的线程结束
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
//查看余票 如果没有线程锁 则会出现卖了100000 但是还有余票 也就是超卖
//        加了线程锁 会为0
        sellWindows.getNum();
//    查看卖出的票 求和
        System.out.println("卖出" + list.stream().mapToInt(i -> i).sum());
    }
}
