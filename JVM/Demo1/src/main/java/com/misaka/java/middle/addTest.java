package com.misaka.java.middle;

public class addTest {
    public static void main(String[] args) {
        int i=10;
        int d=i++;
        int b=10;
        int f=++b;

        sum(3);

    }
    public static int sum(int n){
        if(n==1){
            return  1;
        }
        return  n+sum(n-1);
    }
    public void hot(){
        System.out.println("hot");
    }
}
