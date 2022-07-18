package misaka;

import java.util.ArrayList;
import java.util.List;

public class LocalVar {
    //    局部变量的线程安全测试
    public static void main(String[] args) {
//        ThreadUnSafe threadUnSafe= new ThreadUnSafe();
        TSafe tSafe = new TSafe();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
//                threadUnSafe.ADD();
                tSafe.method();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
//                threadUnSafe.Del();
                tSafe.method();
            }

        });
        t1.start();
        t2.start();
    }

    ;


    //测试类
    static class ThreadUnSafe {
        //    实例变量 作为共享变量 并且该对象外部线程可以访问到 所以发生了逃逸
        List<Integer> list = new ArrayList<>();

        public void ADD() {
            list.add(1);
        }

        private void Del() {
            list.remove(0);
        }
         /* 报错
         * Exception in thread "Thread-1" java.lang.IndexOutOfBoundsException: Index: 0, Size: 107
	       at java.util.ArrayList.rangeCheck(ArrayList.java:659)
	       at java.util.ArrayList.remove(ArrayList.java:498)
	       at misaka.LocalVar$ThreadUnSafe.Del(LocalVar.java:35)
	       at misaka.LocalVar$ThreadUnSafe.access$000(LocalVar.java:27)
	       at misaka.LocalVar.lambda$main$1(LocalVar.java:18)
	       at java.lang.Thread.run(Thread.java:748)
         *
         * */
    }

    //    线程安全
    static class TSafe {
        public void method() {
            //    局部变量 并且没有发生逃逸[外部无法访问] 这时list为线程安全的
            //因为每一个线程都要进来重新创建一个对象 所以不存在共享对象
            List<Integer> list = new ArrayList<>();
            ADD(list);
            Del(list);
        }

        public void ADD(List list) {
            list.add(1);
        }

        private void Del(List list) {
            list.remove(0);
        }
    }
}



