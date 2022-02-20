package com.misaka.java;

public class Son extends Father {
    //    获取父类变量 测试启动类有父类的情况下 父类是否会先调用clinit方法来初始化
    public static void main(String[] args) {
        System.out.println(num); //结果为2 说明父类已经在内部执行了一次 因为调用了静态代码块
    }

}
