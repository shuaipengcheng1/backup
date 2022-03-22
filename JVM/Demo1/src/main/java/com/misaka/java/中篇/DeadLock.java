package com.misaka.java.中篇;

public class DeadLock {
//    通过clinit线程安全 模拟死锁
    static class A{
//      用两个线程  在A内部初始化b 在B内部初始化A
       static B b = new B();
    }
     static  class B{
      static A a = new A();

     }

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
          A a=new A();
          System.out.println("xx");

        });
        t1.start();
        Thread t2 = new Thread(()->{
            B b=new B();
            System.out.println("xb");

        });
        t2.start();
    }
}
