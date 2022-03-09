package com.misaka.java;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
//    弱引用test
public static void main(String[] args) {
//   查看是否GC时直接回收 不管是否达到内存不足和无引用
byte[] bytes = new byte[1];
//包装为弱对象
    WeakReference weakReference = new WeakReference(bytes);
//    删除强引用
    bytes=null;
//    查看是否有值
    System.out.println(weakReference.get()); //[B@16d3586
//    调用GC
    System.gc();
//    查看是否已经回收
    System.out.println(weakReference.get()); //null
//    证明弱引用 只要GC 直接回收
}
}
