package com.misaka.java;

public class Init {
    //    测试初始化阶段
    private static int a = 1;

    static {
       Init. a = 10;
       Init.a=11;
        Init.a=110;

    }

    public static void main(String[] args) {
        System.out.println(a);
    }
}
