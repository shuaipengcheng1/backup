package com.misaka.java;

import java.lang.ref.SoftReference;

public class RefrenceSofttest {
//    测试用例 设置堆空间大小为1g -XX:NewRatio=1 也就是老年代500m 新生代500m
    // 如果softReference对象没被回收 那创建第二个对象时 一定会报OOM报错
    public static void main(String[] args) {
        byte[] bytes = new byte[1024*1024*500]; //500m
//        设置为弱引用
        SoftReference<byte[]> softReference = new SoftReference<>(bytes);
//        删除强引用关联
        bytes=null;
// 再放入一个对像 查看是否会GC清除 弱引用对象来避免OOM
        /*
        * [GC (Allocation Failure) [DefNew: 16778K->579K(471872K), 0.0014024 secs][Tenured: 512000K->512578K(524288K), 0.0015513 secs] 528778K->512578K(996160K), [Metaspace: 2188K->2188K(4480K)], 0.0030337 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[Full GC (Allocation Failure) [Tenured: 512578K->562K(524288K), 0.0010438 secs] 512578K->562K(996160K), [Metaspace: 2188K->2188K(4480K)], 0.0010584 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        *
        * */
//        测试结果成功 就算弱引用对象还有引用指向它 在OOM即将发生时 就会直接回收 来避免OOM
        byte[] bytes2 = new byte[1024*1024*500]; //500m

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
