package com.misaka.java;

public class EspaseTest {
    static Father father;

    //    测试逃逸分析
public static void main(String[] args) {

    //-XX:+DoEscapeAnalysis
 long start=   System.currentTimeMillis();
    for (long i = 0; i <10000000 ; i++) {
        Do();
    }
    long end = System.currentTimeMillis();
    System.out.println(end-start+"ms");
    try {
        Thread.sleep(100000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
public static void Do(){
//    该对象没有调用外部变量 所以逃逸分析会将其优化为栈上分配
User user =new User();
user.a=10;
Father father =new Father();
}

static class User{
 int a ;
}
}
