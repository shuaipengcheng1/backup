package com.misaka.java;

public class StringTest2 {
//    测试 new String() 能创建几个对象
public static void main(String[] args) {
    new String("ab");
//    会创建两个
    /*
    *  new 类型  时会创建一个对应类型的对象在堆空间中
    *  "ab" 在字节码中代码为 ldc ab   就是在常量池中存储一个"ab"对象
    *
    * */

    String s1 = new String("1")+new String("1"); //这里拼接字符串 因为是变量拼接 那么会使用StringBUilder.toString 该方法不会添加字符串到字符串常量池中
    String s2 ="11"; // 添加一个"11"到字符串常量池中 并且s2指向它
    s1.intern(); // 判断字符串常量池中 是否有 11 有就直接返回地址 没有就新加  明显常量池中已经有了 所以不会有任何操作
    System.out.println(s1==s2); //s1 指向的是堆内存中的String对象 值为11
                                //s2 指向的是字符串常量池中的"11"       所以为false
}
}
