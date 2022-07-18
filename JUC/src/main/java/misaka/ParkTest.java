package misaka;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {
//    打断Park线程
public static void main(String[] args) {
 Thread t1 = new Thread(()->{
//     调用park
     System.out.println("Park");
     LockSupport.park();// Park的作用也是暂停当前的线程 当状态为true时 也就是打断时 结束暂停
     //    打断 会清空状态
     System.out.println("UnPark 状态"+Thread.currentThread().isInterrupted());
     Thread.interrupted(); // 清空打断的状态 为false
     LockSupport.park(); // 状态为true时 无法使用park暂停线程
 });
 t1.start();
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
//    打断 不会清空打断状态
    t1.interrupt();
}

}
