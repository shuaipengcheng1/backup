package com.misaka.java;

import java.util.ArrayList;

public class OutMemory {
    static ArrayList arrayList =new ArrayList();
    public OutMemory(int id){
        while (true){
            Add();
        }
    }
    public void Add(){
        while (true){
            arrayList.add(this);

            arrayList.add(this);
            arrayList.add(this);
            arrayList.add(this);
            arrayList.add(this);

        }
    }
}
