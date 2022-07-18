package misaka;

public class WaitTest2 {
    static Integer re =0;
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
//            占用锁 并且进入该锁的moniter的 waitSet中 并让出占用状态
            synchronized (re){
                try {
                    re.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t0 解放了");
            }
        });
        Thread t2 = new Thread(()->{
//            占用锁 进入锁的moniter中 解放t1
            synchronized (re){
//                解放t1线程
                re.notifyAll();
                System.out.println("线程2结束");
            }
        });
        t1.start();  // t1进入re的moniter中WaitSet等待 并且移出占用状态(Owner)
        t2.start(); // t2 进入re的moniter中 调用notify waitSet的线程 就会被激活 并且放入EntrySet中 等待被调用

    }
}
