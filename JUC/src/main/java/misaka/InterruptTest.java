package misaka;

import java.util.ArrayList;

public class InterruptTest {
//    测试打断
public static void main(String[] args) {
ArrayList arrayList = new ArrayList();

    Thread t1 = new Thread(()->{
        while (true){
         if(Thread.currentThread().isInterrupted()){
             System.out.println("被打断了");
             break;
         }
        }
    },"t1");
    t1.start();
    System.out.println("打断");
    t1.interrupt(); // 打断
}
}
