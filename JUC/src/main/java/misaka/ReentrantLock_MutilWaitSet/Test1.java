package misaka.ReentrantLock_MutilWaitSet;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {
    static ReentrantLock lock = new ReentrantLock();
    static Condition room = lock.newCondition();
    static boolean Has = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
//   等待
            if (!Has) {
                System.out.println("t1开始等待");
                try {
                    room.await();
                    System.out.println("继续");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        });
        Thread t2 = new Thread(() -> {
            lock.lock();
//       修改状态
            Has = true;
//          释放等待线程
            System.out.println("解锁");
            room.signal();
//          释放占用的锁 给等待的线程运行 否则会造成死锁现象
            lock.unlock();
        });
        t1.start();
        t2.start();
    }
}
