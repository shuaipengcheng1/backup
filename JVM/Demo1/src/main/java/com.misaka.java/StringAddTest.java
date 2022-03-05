package com.misaka.java;

public class StringAddTest {
    public static void main(String[] args) {
//Add();
        append();
    }
    public static void Add(){
        String str = "";
      long start=  System.currentTimeMillis();
        for (int j = 0; j < 1000000; j++) {
           String s= str+j;
        }
        long end =  System.currentTimeMillis();
     System.out.println("Add"+(end-start)+"ms"); //50ms
    }
    public static void append(){
        StringBuilder str = new StringBuilder(1000000);
        long start=  System.currentTimeMillis();
        for (int j = 0; j < 1000000; j++) {
           str.append(j);
        }
        long end =  System.currentTimeMillis();
        System.out.println("ap"+(end-start)+"ms"); //38ms
    }
}
