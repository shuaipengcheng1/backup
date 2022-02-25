package com.misaka.java;

import java.util.Arrays;

public class StackRetest {
//    栈复习
    int[] Stack  =new int[10];
    public int Key=-1;

//    压入
    public void push(int data){
        if(Key< Stack.length){
            ++Key;
            Stack[Key]=data;
            System.out.println(Arrays.toString(Stack));
        }else {
            System.out.println("栈满");
        }
    }
//    压出
    public  void pop(){
        if(Key>=0){
            Stack[Key]=0;

            --Key;
            System.out.println(Arrays.toString(Stack));


        }else {
            System.out.println("栈空");
        }
    }

    public static void main(String[] args) {
        StackRetest stackRetest  =new StackRetest();
        stackRetest.push(10);
        stackRetest.push(10);
        stackRetest.push(10);
        stackRetest.push(10);
        stackRetest.push(10);
        stackRetest.push(10);
        stackRetest.push(10);
        stackRetest.push(10);
        stackRetest.push(10);
        stackRetest.push(10);
        stackRetest.pop();
        stackRetest.push(10);



    }
}
