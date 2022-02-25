package com.misaka.java;

import java.lang.reflect.Method;

public class ThreadSafe {
    static int num = 10;
    static StringBuilder stringBuilder = new StringBuilder();
static  StringBuffer stringBuffer =new StringBuffer();
    public static void Method1() {
        int i=0;


            stringBuilder.append("a");


        stringBuffer.append("a");
//        线程沉睡2s 模拟操作
//        try {
//            Thread.sleep(2000);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        num++;
        System.out.println(Thread.currentThread().getName() + "线程" + num+stringBuilder+stringBuffer);

    }

    //    测试线程安全问题
    public static void main(String[] args) {
//        线程调用方法
        new Thread(()->{
            Method1();

        }).start();
        new Thread(() -> {
            stringBuilder.append("b");
            stringBuffer.append("b");

            num++;
            System.out.println(Thread.currentThread().getName() + "线程" + num+stringBuilder);
        }).start();
    }
}
