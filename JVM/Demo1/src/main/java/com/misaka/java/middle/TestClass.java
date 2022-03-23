package com.misaka.java.middle;

public class TestClass {
    public static void main(String[] args) {
        Integer i1=10;
        Integer i2=10;
        System.out.println(i1==i2);
        // 提前猜想 10小于byte的取值 128 而 在java基础中 我们知道 -127 - 127的值在内存中有备份
        // 如果有需要 会直接调用 所以为true
        // 128大于127 所以重新在堆空间中开辟对象空间 所以为false
//        从字节码上面可以看到 调用了Interger的valueof方法 里面就有一个属性叫做Interger.cache存储的就是-127  - 127的数组 作为缓存
        Integer i3 =128;
        Integer i4=128;
        System.out.println(i3==i4);

        Integer i5=5;
        int i6=5;
        System.out.println(i5==i6);//自动拆箱 底层会调用一个方法叫做intValue()
        // 官方的注释   Returns the value of this Integer as an int.(返回Integer对象作为Int)
    }
}
