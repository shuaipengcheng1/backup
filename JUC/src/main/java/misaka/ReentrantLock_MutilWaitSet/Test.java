package misaka.ReentrantLock_MutilWaitSet;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 配合Lock  实现线程的等待 与通知
 */
public class Test {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                condition.await();
                System.out.println("继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }).start();
        new Thread(() -> {
            lock.lock();
            try {
                Thread.sleep(2000);
                condition.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
//   这个api运行完后 不会释放锁 必须自己手动释放 否则其他线程 无法运行 因为被占用了锁 [死锁]
                lock.unlock();
            }
        }).start();

    }
}