package misaka;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    //    测试
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
//   t1线程中等待 线程  并且测试她的可打断 在他等待时 用interrupt打断它的等待
        Thread t1 = new Thread(() -> {
//            try {
////                加锁 该对象内部 就是monitor 也有阻塞队列 Owner信息 这里 相当于直接将当前线程作为Owner 如果有Owner 就进入WaitSet
//                reentrantLock.lockInterruptibly();
//            } catch (InterruptedException e) { //被打断后 进入Catch块中
//                e.printStackTrace();
//                System.out.println("没有获取到锁 被打断了~");
//                return;
//            }

//            最大时间锁
            try {
//                最多等待3s 否则报错
                boolean state=    reentrantLock.tryLock(3, TimeUnit.SECONDS);
                if(!state){
                    System.out.println("发生死锁 结束获取");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("获取到了");
            reentrantLock.unlock(); //解锁
        });

        reentrantLock.lock(); // 主线程加锁
        t1.start();

//        t1.interrupt(); //打断

    }
}
