package com.misaka.java;

public class RefrenceStrongTest {
//    强引用测试
public static void main(String[] args) {
    String s1= new String("a");
    String s2 =s1;
    s1=null;
    System.gc(); //因为是强引用 所以String对象不会被回收 因为String对象还有S2指向
}
}
