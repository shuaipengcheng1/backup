package misaka;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS_TEST {
    //    测试 AtomInteger的CompareAndSet方法
    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(() -> {


            for (int i = 0; i < 50000; i++) {
//            test.safe();
                test.Safe();
            }

        });
        Thread t2 = new Thread(() -> {
//            long start = System.currentTimeMillis();

            for (int i = 0; i < 50000; i++) {
//            test.safe();
                test.Safe();

            }
//            System.out.println(start-System.currentTimeMillis());

        });
        long start = System.currentTimeMillis();

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-start);   // CAS 5ms syn 11ms

        test.get();
    }

    static class Test {
        private AtomicInteger value = new AtomicInteger(1000000);
        private int valu = 1000000;

        //    多线程方法 线程不安全
        public void safe() {
            synchronized (this) {
                valu -= 10;
            }
        }

        //     线程安全
        public void Safe() {
            while (true) {
                //        获取最新值
                int prev = value.get();
//       减去后的值
                int num = prev - 10;

                // CAS如果返回true就说明替换成功
                if (value.compareAndSet(prev, num)) {
                    break; //如果为false 就重新获取

                    /*
                    * 如果AtomicReference对象的当前值等于期望值，则使用AtomicReference类的compareAndSet()方法以原子方式将newValue的值设置为AtomicReference对象，如果操作成功，则返回true，否则返回false。此方法使用设置的内存语义更新值，就像将该变量声明为volatile一样。
                    *
                    * */

                    /*1.取得当前值 value.get();
                     2.计算-10后的值
                     3.如果当前值还不是-10后的值(第二步的值) 就将value变为该值
                     4.如果设置没成功(即被别的线程改过了 也就是当前值==期望值), 再从第一步开始. 所以要使用一个while循环
                    *
                    * */
                }

            }


        }

        public void get() {
            System.out.println(value + " " + valu);
        }

    }
}
