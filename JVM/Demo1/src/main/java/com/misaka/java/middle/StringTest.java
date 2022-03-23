package com.misaka.java.middle;

public class StringTest {
    public static void main(String[] args) {
        String str = new String("hello")+new String("world"); //该字符串值不会存储到字符串常量池中 因为StringBUilder的toString()方法
        // 不会将字符串添加到常量池中 而是在堆内存中 这里如果想使str==str1 那么就要调用intern()方法
        // 并且jdk必须大于6 调用intern()后 jvm会将str的堆内存地址 作为对应字符串的地址 这样可以省下一个String的内存
        //jdk6之前 调用intern()后 就是在字符串常量池中 new String(对应字符串) 比较浪费空间
        // intern() : 检查字符串字面量是否在字符串常量池中存在 如果存在
        // >jdk7 : 将对应的字符串地址 复制到字符串常量池中 作为对于字符串的地址 下次有变量使用该字符串 就直接调用
        // <jdk7 : 将对应的字符串创建一个该字符串的对象 存储到常量池中 下次有变量使用该字符串 就直接调用
//        str.intern(); true
        String str1 ="helloworld";
        System.out.println(str==str1);//无 intern()  false 因为str在堆内存中 而str1在字符串常量池中 肯定不相等
                                     // 有 intern() true 首先str调用intern() 然后jvm发现字符串常量池中没有该值
                                     // 所以将str的地址作为"helloworld"字符串的引用
                                     // 所以 str1="helloworld" 就相当于 str1=str; 所以为true
    }
}
