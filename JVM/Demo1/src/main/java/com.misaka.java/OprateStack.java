package com.misaka.java;

public class OprateStack {
//    操作数栈
public static void main(String[] args) {
    byte a =10;
    int b =5;
    int c =a+b;

    /*  解析字节码
    *    i 代表int
    * 0 bipush 10  存储一个int类型的数为10到操作数栈中
    *
      2 istore_1   存储该值并且放在局部变量表的变量槽1中 变量槽0为this or args
      *
      3 iconst_5   存储一个int类型的数为5到操作数栈中
      *
      4 istore_2   存储该值并且放在局部变量表的变量槽2中
      *
      5 iload_1   取出局部变量表中槽位为1的值 并且放在操作数栈中
      *
      6 iload_2   取出局部变量表中槽位为2的值 并且放在操作数栈中
      *
      7 iadd      对所有操作数栈的值进行加法运算 并且将结果压入操作数栈中
      *
      8 istore_3  将结果保存到局部变量表的第三个槽位中
      *
      9 return
    *
    * */
}
public void test(){
    int i=0;
    i++;
    ++i;
}
}
