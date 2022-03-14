package com.misaka.java;

public class Wu {
    private int Myname;
    private String name = null;

    public Wu(int myname) {
        this("xxx"); //这样外部不能修改name 这里只是调用构造函数的方法体 不会创建额外的对象 所以不会有内存泄漏的问题
                           //这里就是调用了下面的构造器 和方法重载一个道理 通过形参列表来判断要使用的构造函数
        Myname = myname;
    }

    public Wu(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println(MyName2());
        Wu wu = new Wu(10);
        System.out.println(wu.name);

    }


    public static int MyName2() {
        Wu wu = new Wu(10);
        System.out.println(wu.name); //xxxx
        wu.Myname += 2;
        return wu.Myname;
    }
}
