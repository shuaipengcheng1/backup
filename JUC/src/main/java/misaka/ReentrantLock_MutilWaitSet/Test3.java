package misaka.ReentrantLock_MutilWaitSet;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {
//    创建线程锁 ReentrantLock 不会自动释放锁 必须通过调用 unlock来释放
    static ReentrantLock reentrantLock = new ReentrantLock();
//  创建WaitSet
    static Condition  DenYan = reentrantLock.newCondition();
//    状态
    static boolean hasYan=false;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
//            获取线程锁
            reentrantLock.lock();
//            判断
            if(!hasYan){
//
                System.out.println("没yan");
//                等待
                try {
                    DenYan.await();
                    System.out.println("youyan");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }
        });
        Thread t2 = new Thread(()->{
//            获取锁
            reentrantLock.lock();
            System.out.println("yabn来了");
            hasYan=true;
//            释放
            DenYan.signal();
//            释放锁 让其他线程运行
            reentrantLock.unlock();
        });
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
