package misaka;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampRefrenceTest {
    public static void main(String[] args) {
           Test test = new Test();
           new Thread(()->{
               test.Change();
           }).start();
           new Thread(()->{
               test.Change();

           }).start();
    }

    static class Test {
        static AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("A", 0);

        public void Change() {
            while (true) {
//                获取当前的版本号
                int stamp = atomicStampedReference.getStamp();
//                获取当前的字符
                String str = atomicStampedReference.getReference();
                if (atomicStampedReference.compareAndSet(str, "A", stamp, ++stamp)) {
                    System.out.println(Thread.currentThread().getName() + "修改了");
                    break;
                }
            }
        }
    }
}
