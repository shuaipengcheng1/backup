package com.misaka.java;

import java.util.ArrayList;
import java.util.List;

public class StopTheWorldDemo {
    //    测试STW
//    设置两个线程 一个为输出 一个为触发System.gc()
    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        WorkThread workThread = new WorkThread();


//通过lamba 表达式来实现java的函数式编程 复习
//        java c c++   为编译阶段语言 所以要声明数据类型 通过数据类型判断存储类型
//        js php python为运行阶段语言 所以不用设置数据类型  通过变量值来判断存储类型
        Thread thread = new Thread(() -> {
            System.out.println("hello" + Thread.currentThread().getName());
        });
        workThread.start();
        printThread.start();
        thread.start();
    }


//    测试结果
//    1 正常模式 无GC调用时 输出清空
    /* 可以看到ms在10左右波动
    * 1008ms
1006ms
1010ms
1004ms
1006ms
1006ms
1005ms
1001ms
1002ms
1009ms
1005ms
1005ms
1004ms
1006ms
    *
    * */
//    2 开启GC 查看STW
    /* 几乎全都大于10ms 只有一个没有STW清况 最大停顿为29ms
    *1014ms
1017ms
1014ms
1016ms
1013ms
1024ms
1012ms
1027ms
1017ms
1029ms
1021ms
1003ms
    *
    *
    * */



    static class WorkThread extends Thread {

        @Override
        public void run() {
            super.run();
            List list = new ArrayList();
            while (true) {
                list.add(10000);
                if (list.size() > 1000000) {
                    list.clear(); //断开数据
                    System.gc();

                }
            }
        }
    }

    static class PrintThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() - start + "ms");
            }
        }
    }
}
