package misaka;

public class DeadLock {
    //    死锁现象
//    线程1 需要线程2的锁对象 但是线程2锁住了该对象 并且在线程2内部 要入锁线程1的锁对象 [因为线程1要线程2的锁对象 获取不到 导致无法释放锁 线程2也就获取不到线程1的锁对象 所以两边都无法释放 导致死锁]
    static Object object1 = new Object();
    static Object object = new Object();

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            synchronized (object) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){

               }

            }
        });
        Thread thread1 = new Thread(() -> {
            synchronized (object1) {
                synchronized (object){

                }
            }
        });
        thread.start();
        thread1.start();
    }


}
