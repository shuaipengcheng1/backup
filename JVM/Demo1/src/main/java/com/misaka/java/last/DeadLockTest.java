package com.misaka.java.last;

public class DeadLockTest {
    public static void main(String[] args) {
//        使用统一对象
        MyTest myTest = new MyTest("10", "misaka");
//       创建两个线程
        Thread t1 = new Thread(() -> {
        myTest.setName();
        });
        Thread t2 = new Thread(() -> {
  myTest.setAge();
        });
        t1.setName("1");
        t2.setName("2");
        t1.start();
        t2.start();
    }

    //    用于公用的类
    static class MyTest {
        String age;
        String name;

        public MyTest(String age, String name) {
            this.age = age;
            this.name = name;
        }

        public MyTest() {
        }
//t2
        public void setAge() {
            synchronized (this.age) {
                if(Thread.currentThread().getName().equals("2")) {
                    System.out.println("当前线程"+Thread.currentThread());
                    setName(); //调用name方法 但在这时 name方法被t1锁住了 并且

                }
            }
        }
//t1
        public void setName() {
            synchronized (this.name) {
                if(Thread.currentThread().getName().equals("1")) {
                    System.out.println("name当前线程"+Thread.currentThread());

                    setAge();

                }
            }
        }
    }
//    阻塞方法

}
