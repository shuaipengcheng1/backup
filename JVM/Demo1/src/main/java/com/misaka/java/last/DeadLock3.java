package com.misaka.java.last;

public class DeadLock3 {
    String num;
    String name;

    public DeadLock3(String num,String name) {
        this.num = num;
        this.name=name;
    }

    public static void main(String[] args) {
//        死锁测试       两个线程都用 num 为10的条件进入方法
//
DeadLock3 deadLock3 = new DeadLock3("10","misaka");
Thread t1 = new Thread(()->{
    deadLock3.Method1();
});
Thread t2 = new Thread(()->{
   deadLock3.Method2();
});
t1.start();
t2.start();

    }
//  创建两个方法
    public void Method1(){
        synchronized (this.num){
            System.out.println(this);
            this.Method2();
        }
    }
    public void Method2(){
        synchronized (this.name){
            System.out.println(this);

            this. Method1();
        }
    }
}
