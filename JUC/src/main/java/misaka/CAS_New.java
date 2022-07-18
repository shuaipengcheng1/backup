package misaka;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS_New {
    public static void main(String[] args) {
        Test test = new Test();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                test.TestMethod();

            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                test.TestMethod();

            }
        });

        thread.start();
        thread1.start();
        try {
            thread1.join();

            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(test.getAtomicInteger());

    }

    static class Test {
        AtomicInteger atomicInteger = new AtomicInteger(1000);

        public AtomicInteger getAtomicInteger() {
            return atomicInteger;
        }

        public void TestMethod() {
//            while (true) {
//                int prev = atomicInteger.get();
//                int next = prev + 1;
//                if (atomicInteger.compareAndSet(prev, next)) {
//                    break;
//                }
//            }
//          atomicInteger.incrementAndGet(); //i++
//          atomicInteger.addAndGet(1);
//          update and get 是一个函数接口
            atomicInteger.updateAndGet(x->x*2); // x 为当前值 方法体对x的修改会赋值给当前值·


        }
    }
}
