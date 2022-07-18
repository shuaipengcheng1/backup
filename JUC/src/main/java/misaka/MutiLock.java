package misaka;

public class MutiLock {
    //    多锁结构 防止互不相干的方法 由于锁 导致多线程并发量降低
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(() -> {
            lockTest.sleep();
        }).start();
        new Thread(() -> {
            lockTest.study();
        }).start();

    }

    static class LockTest {
        final static Object SLEEP_LOCK=new Object();
        final static Object STUDY_LOCK=new Object();

        public void sleep() {
//        this同步锁 会导致两个线程并发效果很慢 因为一个线程要等待另一个线程的结束
//            所以不同的方法 使用不同的锁
            synchronized (SLEEP_LOCK) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sleep");
            }
        }

        public void study() {
            synchronized (STUDY_LOCK) {
                System.out.println("study");

            }
        }
    }

}
