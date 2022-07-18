package misaka;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ConcureentTest {
//    用 wait notify 和 EeentrantLock实现同步
    static Object obj = new Object();

//    标识1是否已经输出
    static boolean First=false;

    static ReentrantLock reentrantLock = new ReentrantLock();
    static boolean First2=false;

    //    创建一个等待区
    static Condition Wait = reentrantLock.newCondition();

    static boolean ParkState =false;
public static void main(String[] args) {
//    两个线程
    Thread t1 = new Thread(()->{
        synchronized (obj){
            System.out.println(1);
            First=true;
            obj.notify();

        }
    });
    Thread t2 = new Thread(()->{
        synchronized (obj){
//            如果第一个还没有执行 就输出
          while (!First){
              try {
                  obj.wait();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
          System.out.println(2);
        }
    });
    t2.start();
    t1.start();


//    用ReentrantLock实现
    Thread t3 = new Thread(()->{
//        获取线程锁
        reentrantLock.lock();
        First2=true;
        System.out.println(1);

        Wait.signal();
        reentrantLock.unlock();
    });
    Thread t4 = new Thread(()->{
        reentrantLock.lock();
        if(!First2){
            try {
                Wait.await();
                System.out.println(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    });
    t4.start();
    t3.start();

//    park unpark

    Thread t6 = new Thread(()->{
        while (!ParkState){
//            暂停
            LockSupport.park();

        }
        System.out.println(2);


    });
    Thread t5 = new Thread(()->{
        System.out.println(1);
        ParkState=true;
//      解除
        LockSupport.unpark(t6);
    });
    t6.start();
    t5.start();
}

}
