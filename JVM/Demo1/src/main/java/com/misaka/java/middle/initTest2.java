package com.misaka.java.middle;

public class initTest2 {
/*
* 测试不会触发初始化阶段的字节码
*   1 使用的是类的 静态常量字段 因为静态常量不需要再clinit方法中赋值 它已经在链接阶段的解析时就已经显式的赋值为10了
* {static final复习}
* 如果该修饰符 修饰的变量 赋值的是一个字面量"xxx" 或者是一个基本数据类型 就是在链接阶段赋值 就不会调用clinit方法
* 但是如果修饰的变量 是一个引用数据类型的值 就要在初始化阶段进行赋值 就会触发init
* */
public static void main(String[] args) {
//int a=Test1.a; //未触发
int b =Test1.b; //触发
//   String s =Son.string; //只有父类初始化了
    int x=  Son.x;
//    int a=Test10.a;
//    Test10 test10 = new Test10(); //实例化对象 会初始化
//int bq = test10.b
}
}
class Test1{
    static {
        System.out.println("初始化");
    }
    static final int a =10;
    static final int b = (int) (Math.random()*100);

}
class Test10{
    static {
        System.out.println("Test10初始化了");
    }
    public   static final int a =10; //静态常量 如果赋值是基本数据类型或者字面量 就不会初始化 因为在连接阶段的解析就会显式赋值
    final int b=20;//常量 也不会初始化 常量在编译阶段就已经赋值了
}
class Parent{
    static {
        System.out.println("Father");
    }
   public static String string = new String("xxx");
    public static String s ="xx"; //只要没有final修饰的静态变量绝对是通过初始化阶段显式赋值  如果修饰 则要看显式赋值的类型 如果是字面量和基本数据类型 就通过连接阶段的解析过程来显式赋值 否则就是初始化阶段赋值
   public  static  int x; //这个值也会进入初始化阶段       3 当使用类 接口的静态字段时(final static 要看显式赋值是否是new对象) 比如使用 getstatic putstatic 指令

}
class  Son extends Parent{
    static {
        System.out.println("Son");
    }
}

