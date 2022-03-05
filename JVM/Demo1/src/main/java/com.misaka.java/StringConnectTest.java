package com.misaka.java;

public class StringConnectTest {
//    测试不同情况下的字符串拼接操作
    static final String a="a";
    static final String b="b";

    public static void main(String[] args) {
//        测试常量*************************************************************************
        FinalConnect(a,b);
        String S1="abc";//这里的操作是 将"abc"放入字符串常量池中 并且返回地址给S1
        String S2="a"+"b"+"c"; // 这里就是要判断是否也是使用的字符串常量池的值
  /*
           字节码文件的编译结果显而易见
                  String S1 = "abc";
        String S2 = "abc";
        System.out.println(S1 == S2);
        System.out.println(S1.equals(S2));
* */
        System.out.println(a+b);// 常量池的字符串拼接都是放在字符串常量池中的 这个叫编译期优化
        System.out.println(S1==S2); //true
        System.out.println(S1.equals(S2));//true

//        测试有变量的场景********************************************************
        String t ="hellox";
        String t1 = "hello";
        String t2 = t1+"x";
//        将t2的值放入字符串常量池中 并且赋值地址给t3
     String t3  = t2.intern();
        System.out.println(t==t2); //false 因为字符串拼接时有变量 那底层会将其放在堆空间中 而不是字符串常量池中
        System.out.println(t==t3); //true 这这里已经将t3的值放入了字符串常量池中 根据字符长常量池中字符不能重复的规则 所以直接引用已有的地址 所以为true
        System.out.println(t.equals(t2)); //true


        //*****************************测试变量字符串拼接的比较
        String c1 = "hello";
        String c2 ="x";
        String c3 =c1+c2;
        String c4 =c1+c2;
        System.out.println(c3==c4); //false 因为变量字符串拼接 结果是存储在堆内存中的 堆内存没有对字符串做不可重复的限制(底层不是hashTable) 所以有一个新的 就开辟一个新的空间
    }
    public  static void FinalConnect(String a,String b){
        System.out.println(a+b); //使用的是StringBuilder.append(a) StringBuilder.append(b)
    }

}
