package com.misaka.java.middle;

public class switchTest {
    public static  void x(){
        System.out.println("x");
    }
    public static void main(String[] args) {
 switchTest.x();
    }
//    连续的
    public void Switch1(int num){
        switch (num){
            case 0:System.out.println(num);break;
            case 1:System.out.println(num);break;
            case 2:System.out.println(num);break;
            case 3:System.out.println(num);break;

        }
    }
//    不连续
    public void Switch2(int num){
        switch (num){
            case 0:System.out.println(num);break;
            case 10:System.out.println(num);break;
            case 2:System.out.println(num);break;
            case 100:System.out.println(num);break;

        }
    }
}
