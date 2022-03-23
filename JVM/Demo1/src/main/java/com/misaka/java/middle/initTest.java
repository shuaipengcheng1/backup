package com.misaka.java.middle;
/*
      8 当初次调用MethodHandle实例时 初始化该类指向的方法所在类
* */
public class initTest {
       //   7 当jvm启动时 用户需要指定一个要执行的主类 也就是main方法 虚拟机会初始化该主类
    static {
        System.out.println("hello 初始化4");
    }
    public static void main(String[] args) {

        //*       1 当创建一个类的实例时 比如使用new关键字 或者通过反射 克隆 序列化
        Test test =new Test();
        //      2 当调用类的静态方法时 即当使用了字节码invokestatic指令
        Test2.x();
        //      3 当使用类 接口的静态字段时(final static 要看显式赋值是否是new对象) 比如使用 getstatic putstatic 指令
       int num= Test3.a;
        try {
            //   7 当jvm启动时 用户需要指定一个要执行的主类 也就是main方法 虚拟机会初始化该主类
            Class.forName("com.misaka.java.middle.initTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       // 5 当初始化子类 如果父类还没有进行初始化 则要触发父类初始化
    Test5 test5 = new Test5();
        //  6 如果一个接口定义了default方法 那么直接实现或者间接实现该接口的类的初始化 该接口要在之前被初始化
 String s=Test7.string;

    }
}
class Test{
    static {
        System.out.println("hello 初始化阶段");
    }
}
class Test2{
    static {
        System.out.println("hello 初始化阶2");
    }
    public static void x(){
        System.out.println("x");
    }

}
class Test3{
    static {
        System.out.println("hello 初始化阶3");
    }
    static int a=10;
}

class Test4{
    static {
        System.out.println("hello 初始化阶father");
    }
}
class Test5 extends Test4{
    static {
        System.out.println("hello 初始化阶son");
    }
}

//  6 如果一个接口定义了default方法 那么直接实现或者间接实现该接口的类的初始化 该接口要在之前被初始化

class Test7 implements Test6{
    static {
        System.out.println("Test7");
    }
    static final  String string = new String("sss");


}
    //  6 如果一个接口定义了default方法 那么直接实现或者间接实现该接口的类的初始化 该接口要在之前被初始化
interface  Test6{
    public static final Thread th =new Thread(){
        {
            System.out.println("hello Test6");

        }
    };
        //  6 如果一个接口定义了default方法 那么直接实现或者间接实现该接口的类的初始化 该接口要在之前被初始化

        public default void x(){
        System.out.println("de");
    }
}