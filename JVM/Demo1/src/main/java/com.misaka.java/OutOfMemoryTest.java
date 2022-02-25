package com.misaka.java;

import java.util.ArrayList;
import java.util.Map;

public class OutOfMemoryTest {
    public static void main(String[] args) {
        ArrayList arrayList =new ArrayList();
        while (true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            arrayList.add(new OutMemory(1));

            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));
            arrayList.add(new OutMemory(1));

            arrayList.add(new OutMemory(1));
//            System.out.println("he");




        }
    }
}
