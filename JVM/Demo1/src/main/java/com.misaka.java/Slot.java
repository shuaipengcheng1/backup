package com.misaka.java;

public class Slot {
    int c =0;
    public static void main(String[] args) {

    }
    public void Test1(){
//        测试 非静态方法的局部变量表
//        结果
//        有this
//        Slot长度为 2    分别为 this 和 s
    String s = new String();

    }
    public static  void xx(){
//        测试 静态类局部变量表
//        结果
//        无 this
//        Slot长度为1   T
        int T = 102;
    }
    public Slot(){
//        测试 构造器局部变量表
//        结果
//        有this
//        SLot长度为1 this
        this.c=10;
    }

    public void TestBack(){
//        测试下槽位的回收
        int a=10;
//        创建一个局部作用域
        {
            int b=a;
            b=b+a;
        }
        int c=10;
//        上面的Slot长度是多少呢? 答案是3
        // 虽然 有 this a b c 4个局部变量 但是 其中b变量在38行之后就不能使用了 所以空出来的槽位就给了变量c
         // 所以最后只有 this a c 三个局部变量
    }
}
