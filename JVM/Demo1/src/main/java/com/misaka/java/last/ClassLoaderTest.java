package com.misaka.java.last;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {


    public static void main(String[] args) {
        //    测试自定义类
        String url ="D:\\IdeaProject\\JVM\\Demo1\\src\\main\\java\\com\\misaka\\java\\last\\";
        ClassLoderSelfTest classLoderSelfTest = new ClassLoderSelfTest(url);
        try {
          Class cl=  classLoderSelfTest.findClass("TEST");
            try {
                //          反射机制
                Object o=   cl.newInstance();
                try {
                    //                获取指定的方法
                    Method method= cl.getMethod("hot");
                    try {
//                        调用方法
                        method.invoke(o);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
