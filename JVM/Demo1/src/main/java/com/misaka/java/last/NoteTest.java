package com.misaka.java.last;

import java.util.Scanner;

public class NoteTest {
    final int a = 10; //常量池赋值 编译阶段
    final String b = "S"; //常量池赋值 编译阶段
    static final String c = new String("xx"); //<clinit>()赋值 初始化阶段
    static final String d = "ccc"; //常量池赋值 编译阶段
    int ff = 10; //<init> 赋值
    static int fs = 102; //<clinit>()赋值 初始化阶段
    static String das = "ccc";//<clinit>()赋值 初始化阶段
    String sf = new String("xxsa"); //<init> 赋值

    public static void main(String[] args) {
   String str = "hello world"; //490
        str = "111"; //492
        String s = "hello world";//490

        s=null;
        Scanner scanner = new Scanner(System.in);


        System.gc();
        String s2 = "hello world";//490

        System.out.println();

        String str1 = new String("a")+new String("b");
//        这里底层拼接使用的是 StringBuilder 不会将字符串结果 存入字符串常量池
        // jdk7: 调用 将ab存入字符串常量池 值为 str1的地址[省了一个"ab"的内存]   jdk6 : 在字符串常量池中新建ab字符串[这样会多一个"ab"的内存]
        str1.intern();
        String s1 = "ab"; // 这里s1指向字符串常量池的"ab" 而ab的值是str1 所以等于 s1=str1 所以true
        String s3 =new String("ab"); //这里s3指向的是一个堆内存地址 s3==str1 false
        System.out.println(s1==str1); //true  如果jdk6 就是false

    }
}
