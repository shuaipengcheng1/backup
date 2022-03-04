package com.misaka.java;

import java.io.*;

public class StringSave {
    //    通过Stirng的intern()方法来存储字符串到常量池中
//    并且查看字符串常量池大小 对运行时长的影响
    // -XX:StringTableSize
    // 1009大小 228
    // 100009大小 80
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("word.txt"));
        String s = null;
        long start = System.currentTimeMillis();
        while ((s = bufferedReader.readLine()) != null) {
//    逐行读取 直到为空值
//    intern() 方法
//    将对应的字符串对象的值存储到字符串常量池中 如果存在就不存储
            s.intern();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
