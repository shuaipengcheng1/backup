package com.misaka.java;

import java.io.FileWriter;

public class StringMakeing {
    public static void main(String[] args) throws Exception{
        FileWriter fileWriter =new FileWriter("word.txt",true);

        for (int i = 0; i <100000 ; i++) {
//           随机写入1-10个数据
            int Length = (int) (Math.random() * 10);
            fileWriter.write(getString(Length)+"\n");

        }
        fileWriter.close();
    }
//    获取数据
    public static String getString(int L){
        String s = null;
        for (int i = 0; i < L; i++) {
//            65 -128的数据
            int num = (int)(Math.random()*(128-65+1)+65);
            s+=(char)num;
        }
        return s;
    }
}
