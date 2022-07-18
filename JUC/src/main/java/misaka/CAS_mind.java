package misaka;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CAS_mind {
    public static void main(String[] args) {
        Test test = new Test();
       new Thread(()->{
       test.lock();
           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           test.unLock();
       }).start();
        new Thread(()->{
            test.lock();
            test.unLock();

        }).start();
    }

    //    测试类
    static class Test {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        public void lock() {
            while (true) {
                if (atomicInteger.compareAndSet(0, 1)) {
                    System.out.println(Thread.currentThread().getName()+"上锁");
                    break;
                }
            }
        }
        public void unLock(){
            atomicInteger.set(0);
            System.out.println("释放");

        }

    }
}
