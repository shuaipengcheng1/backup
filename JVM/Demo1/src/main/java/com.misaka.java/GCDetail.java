package com.misaka.java;

import java.util.ArrayList;
import java.util.List;

public class GCDetail {
    public static void main(String[] args) {
        List l = new ArrayList();
        String a = "hello world!";
        while (true){
            a=a+a;
        }
    }
}
