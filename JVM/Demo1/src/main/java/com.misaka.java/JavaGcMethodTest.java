package com.misaka.java;

public class JavaGcMethodTest {
    //    测试java垃圾回收算法
    public byte[] mem = new byte[1024 * 1024 * 50]; //50m
    public JavaGcMethodTest refrence;
    public static void main(String[] args) {
      JavaGcMethodTest j1 = new JavaGcMethodTest();
      JavaGcMethodTest j2 = new JavaGcMethodTest();
      j1.refrence=j2; //互相调用
      j2.refrence=j1;
      j1=null;
      j2=null;
//      垃圾回收
      System.gc();

      /*
      * [GC (Allocation Failure) [DefNew: 1533K->512K(4928K), 0.0010260 secs][Tenured: 31K->542K(10944K), 0.0016745 secs] 1533K->542K(15872K), [Metaspace: 2086K->2086K(4480K)], 0.0030201 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 202K->35K(4992K), 0.0004279 secs][Tenured: 51742K->51777K(62148K), 0.0010058 secs] 51945K->51777K(67140K), [Metaspace: 2188K->2188K(4480K)], 0.0016173 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
      * 这里进行了垃圾回收 如果是计数器算法的话 就不会 因为即使j1 和 j2 都不指向堆空间中的对象 但是堆空间的对象中的refrence还有引用 计数器就不为0 所以不会回收
      *
      *
      * */
    }
}
