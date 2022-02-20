package com.misaka.java;

public class ThreadTest {
    //    多线程
    public static void main(String[] args) {
        Runnable r = () -> {

//            if (Thread.currentThread().getName().equals("Thread-0")) {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(Thread.currentThread().getName() + "开始");
            System.out.println(1);
//            创建对象 证明多线程环境下 对象只会被初始化一次 不会初始化第二次 因为cinit有同步锁
            Dead dead = new Dead();
            System.out.println(Thread.currentThread().getName() + "结束");

        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t3");
        });
        t3.start();
        t1.start();
        t2.start();


    }
}
class  Dead{
     static  {
        System.out.println(Thread.currentThread().getName()+"加载");
    }
}
