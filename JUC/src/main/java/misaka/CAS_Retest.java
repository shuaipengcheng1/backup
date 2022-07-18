package misaka;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS_Retest {
    //    复习CAS
    public static void main(String[] args) {
        Test test = new Test();
//    无锁实现 多线程i++;
        Thread t1 = new Thread(()->{
            for (int i = 0; i <5000 ; i++) {
                test.add();
                test.add2();

            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                test.add();
                test.add2();


            }
        });
        t1.start();
        t2.start();
        try {
            t2.join();

            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.atomicInteger.get());
        System.out.println(test.value);
    }

    static class Test {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int value = 0;

        public void add() {
            while (true) {
                //            获取当前值
                int prev =
                        atomicInteger.get();
                int after = prev + 1;
                if (atomicInteger.compareAndSet(prev, after)) {
                    break;
                }

            }
        }

        public void add2() {
            synchronized (this) {
                value++;
            }
        }
    }
}
