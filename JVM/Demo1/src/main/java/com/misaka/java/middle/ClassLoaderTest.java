package com.misaka.java.middle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {
    public static void main(String[] args) {
        SelfClassLoader selfClassLoader = new SelfClassLoader("D:\\IdeaProject\\JVM\\Demo1\\src\\main\\java\\com\\misaka\\java\\middle\\");
        try {
            Class cl = selfClassLoader.findClass("addTest");
            System.out.println("当前类的加载器 " + cl.getClassLoader()); //当前类的加载器 com.misaka.java.middle.SelfClassLoader@48140564
//            测试不同类加载器 是否会多次加载
           Class c= addTest.class.getClassLoader().loadClass("com.misaka.java.middle.addTest");
          System.out.println("系统使用的类加载"+c.getClassLoader()); //jdk.internal.loader.ClassLoaders$AppClassLoader@1f89ab83
            ClassLoaderSelfRetest classLoaderSelfRetest  = new ClassLoaderSelfRetest("D:\\IdeaProject\\JVM\\Demo1\\src\\main\\java\\com\\misaka\\java\\middle\\");
            Class c2 = classLoaderSelfRetest.findClass("addTest");
            System.out.println("第二个自定义类加载器"+c2.getClassLoader());//com.misaka.java.middle.ClassLoaderSelfRetest@2133c8f8

//             创建对象
            try {
//                反射
             Object o=   c2.newInstance();

                try {
//                    获取对应的方法
                   Method method = c2.getMethod("hot");
                    try {
//                        调用方法
                        method.invoke(o);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

//              addTest addTest=  (addTest)o;
//              addTest.hot();

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
