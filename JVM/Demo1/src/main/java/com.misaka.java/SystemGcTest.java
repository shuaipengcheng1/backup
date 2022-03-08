package com.misaka.java;

public class SystemGcTest {
//    测试回收
    public void GCTest1(){
        byte[] bytes =new byte[1024*1024*10];
        System.gc();  //不会回收 因为对象还有引用
    }
    public void GCTest2(){
        byte[] bytes =new byte[1024*1024*10];
        bytes=null;
        System.gc(); //回收
    }
    public void GCTest3(){
        {
            byte[] bytes =new byte[1024*1024*10];
        }
        System.gc(); //不会回收 因为bytes虽然已经脱离了作用域 但是局部变量表中的变量槽1依然是bytes(只是标记为可覆盖 等待下一个变量声明覆盖 不会删除) 所以对象还是有指向
    }
    public void GCTest4(){
        {
            byte[] bytes =new byte[1024*1024*10];

        }
        int value =10;
        System.gc();//回收 因为bytes脱离作用域 然后又声明了value 所以jvm将value值存入了bytes变量原先的局部变量槽中 从而byte对象失去引用 所以回收
    }
    public void GCTest5(){
        GCTest1();
        System.gc(); //会回收GCTest1里面的对象 因为GCTest1方法已经出栈了(从虚拟机栈中脱出) 其内部的局部变量表也会销毁 从而对象失去引用 所以回收

    }

    public static void main(String[] args) {
        SystemGcTest s= new SystemGcTest();
        s.GCTest5();
    }

}
