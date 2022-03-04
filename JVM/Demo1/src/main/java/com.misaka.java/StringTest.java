package com.misaka.java;

public class StringTest {
//    测试String的不可变性
    String str = "hello";
    char[] c = {'t','e','s','t'};
    public void Exchange(String str,char[] c){
//        剖析
//        str传入后 形参是一个赋值操作 str=传入值 此时地址一致
//        str="ex"  这时进行了修改 但是根据字符串不可变 这里只是在字符串常量池中添加了一个新的字符串叫做"ex"
//        并且只是函数体内部的变量指向它 函数外部字符串保持不变
        str="ex";
//        c 是一个数组 形参传入时 内部c和外部c都指向了一个数组 这里修改了数组是会生效的
        c[0]='b';
    }

    public static void main(String[] args) {
        StringTest stringTest =new StringTest();
        stringTest.Exchange(stringTest.str, stringTest.c);
        System.out.println(stringTest.str); //hello
        System.out.println(stringTest.c); //best
    }
}
