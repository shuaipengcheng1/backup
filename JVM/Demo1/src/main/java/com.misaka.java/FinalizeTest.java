package com.misaka.java;

public class FinalizeTest {
//    该对象为GC Root 方法区中的静态变量 指向堆内存中的对象
static FinalizeTest fss;
public byte[] bytes = new byte[1024*1024*200];
    //    测试Finalize方法
    @Override
    protected void finalize() throws Throwable {
//        super.finalize();
        System.out.println("执行资源的释放");
//        测试一下 复活对象
        fss=this;
        System.out.println(this);
        bytes=null;
//        调用GC
//        System.gc();
    }
public static void main(String[] args) {
    FinalizeTest f= new FinalizeTest();
//    我们设置 -Xmx500m -Xms500m -Xx:NewRatio=1  也就是堆内存中 老年区占1/2 年轻代占1/2  也就是250m 并且Eden S0 S1 区域比例为8:1:1 也就是 200 25 25 所以只要对象大于200就会触发
    // mirrorGC
    f=null;


    System.gc();
    try {
        Thread.sleep(20000); //这里如果不暂停就会报错OOM
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    //    再次删除引用 查看finalize() 是不是只执行一次 结果 只执行了一次
    fss=null;


    System.gc();

    try {
        Thread.sleep(10); //这里如果不暂停就会报错OOM
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
//    System.out.println("执行资源的释放"+f);

    FinalizeTest fs= new FinalizeTest();
//    fs=null;

    try {
        Thread.sleep(100000); //这里如果不暂停就会报错OOM
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
