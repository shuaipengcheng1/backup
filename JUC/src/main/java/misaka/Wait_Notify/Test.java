package misaka.Wait_Notify;

public class Test {
    //    一共四个线程
//    第一个进来发现没有yan 则wait
//    第二个进来送烟 并且触发
//    第三个 第四个 直接开干
    static boolean hasYan = false;
    //    任务对象
    static Object renwu = new Integer(10);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (renwu) {
//                循环判断 循环判断还可以解决虚假唤醒 每次叫醒 就去判断一次是否是需要的对象 避免其他的条件导致的唤醒
                while (!hasYan) {
//             没yan
                    System.out.println("no yan");
                    try {
                        renwu.wait();// 任务停止
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t0有了!");
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (renwu) {
             //该线程是送烟的
                hasYan=true;
                try {
                    Thread.sleep(2000); // 暂停 观察其他的线程是否继续执行
//                    sleep 不会执行 因为会占用锁
//                    wait会继续执行 因为会释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("yan 来了");
//                喊醒所有线程
                renwu.notifyAll();
            }
        });
        Thread t3 = new Thread(() -> {
            System.out.println("t3不抽烟 直接运行!");

        });
        Thread t4 = new Thread(() -> {
            synchronized (renwu) {

                System.out.println("t4不抽烟 直接运行!");
            }
        });
        Thread t5= new Thread(() -> {
            synchronized (renwu) {

                System.out.println("t5不抽烟 直接运行!");
            }
        });
        Thread t6= new Thread(() -> {
            synchronized (renwu) {

                System.out.println("t6不抽烟 直接运行!");
            }
        });

        t1.start(); // 没有yan 进入renwu对象的 monitor对象 的 WaitSet集合中进行等待 会释放锁 下面的线程继续执行 sleep的话 就不可以 因为sleep不释放同步锁
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start(); //烟来了 释放wait的线程 并且将其放入EntrySet集合中

    }
}
