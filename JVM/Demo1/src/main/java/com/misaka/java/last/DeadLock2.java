package com.misaka.java.last;

public class DeadLock2 {
//    死锁2 同步锁机制 是当锁一致时 则等待 不同可以同时进入
public static void main(String[] args) {
    Mytest2 mytest2 = new Mytest2("10","misaka");
    Thread thread  = new Thread(()->{
//        mytest2.SetAge();
        mytest2.A("A");
    });
    Thread thread1 = new Thread(()->{
//        mytest2.SetName();
        mytest2.B("B");
    });
    thread.start();
    thread1.start();

}
    static class Mytest2{
        String id;

        public Mytest2(String id, String name) {
            this.id = id;
            this.name = name;
        }

        String name;
        public void SetAge(){
            synchronized (this.id){
                System.out.println("线程"+Thread.currentThread());

                SetName();
            }
        }
        public void SetName(){
            synchronized (this.name){
                System.out.println("线程"+Thread.currentThread());
                SetAge();
            }
        }
                      //这个str是"A"
        public void A(String str){
//            A作为锁值
            synchronized (str){
//                A作为锁值 下一个A就会等待
                System.out.println("线程"+Thread.currentThread());
//                传入一个B
              B("B");
            }
        }
       //            这个str是"B
        public void B(String str){
//            B作为锁值 如果有B值路过则等待
            synchronized (str){
                System.out.println("线程"+Thread.currentThread());
               A("A");
            }
        }
//        复习 同步锁机制
//        1 synchronized内部的值 作为锁 如果下一个线程的锁值等于当前的锁值 就会进入队列等待

    }
}
