package com.misaka.java;

public class MethodTest {
    public static void main(String[] args) {
        X x = ()->{
            System.out.println("hello");
        };
        x.test();
    }



}

 interface X{
    void test();
}