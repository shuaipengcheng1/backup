package com.misaka.java;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhtomReferenceTest {
    //虚引用的作用 就是追踪他所包裹的对象的销毁状态 如果销毁 就将其虚引用对象数据类型为(PhantomReference<所包裹的对象>) 放入队列中
    //    创建一个实例对象
    public static PhtomReferenceTest phtomReferenceTestPhantomReference;
    static ReferenceQueue<PhtomReferenceTest> referenceQueue;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("复活咯");
        //复活对象
        phtomReferenceTestPhantomReference = this;
    }

    //    该线程用于检查对象状态
    static class CheckState extends Thread {
        @Override
        public void run() {

//        检查队列是否为空
            while (true) {

                if (!(referenceQueue == null)) {
//               不为空
                    PhantomReference<PhtomReferenceTest> phtomReferenceTest = null;
                    try {
//                        获取 死亡后放入队列的虚引用对象
                        phtomReferenceTest = (PhantomReference<PhtomReferenceTest>) referenceQueue.remove();
                        System.out.println(phtomReferenceTest + "死亡");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //虚引用的使用
    public static void main(String[] args) throws Exception {
        CheckState checkState = new CheckState();
        checkState.setDaemon(true);//设置为守护线程 意思就是 如果程序中只有守护线程在运行了 那么就结束该线程
        checkState.start();
//        创建对象
        phtomReferenceTestPhantomReference = new PhtomReferenceTest();
//       创建引用队列 用于存放被销毁的虚引用
        referenceQueue = new ReferenceQueue<>();
//        创建虚引用对象
        PhantomReference phantomReference = new PhantomReference(phtomReferenceTestPhantomReference, referenceQueue);
//        获取虚引用的值
        System.out.println(phantomReference.get()); //null
//        删除强引用
        phtomReferenceTestPhantomReference = null;
//        调用GC 虚引用会被 直接回收 但是finalize方法 中 会复活对象
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (phtomReferenceTestPhantomReference == null) {
            System.out.println("死亡咯");
        } else {
            System.out.println("没死");
        }
//        再次调用GC 因为Finalize方法 只能调用一次所以死亡
        phtomReferenceTestPhantomReference = null;
//        调用GC 虚引用会被 直接回收 但是finalize方法 中 会复活对象
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (phtomReferenceTestPhantomReference == null) {
            System.out.println("死亡咯");
        } else {
            System.out.println("没死");
        }
    }
}
