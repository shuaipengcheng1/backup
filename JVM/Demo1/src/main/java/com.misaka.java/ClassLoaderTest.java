package com.misaka.java;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //        获取classLoader的最底层
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        //   输出
        System.out.println(classLoader); //sun.misc.Launcher$AppClassLoader@b4aac2


        ClassLoader extClassLoader = classLoader.getParent();
        //   输出
        System.out.println(extClassLoader); //sun.misc.Launcher$ExtClassLoader@16d3586

         //尝试获取bootstrapClassLoader 结果为null
        System.out.println(extClassLoader.getParent()); //null

//        查看自定义类的类加载器 使用的时AppClassLoader也就是应用类加载器 也是最低层级
        System.out.println(ClassLoaderTest.class.getClassLoader()); //sun.misc.Launcher$AppClassLoader@b4aac2
//   根据反编译获取类加载器
        try {
           ClassLoader s= Class.forName("java.lang.String").getClassLoader();
      System.out.println(s); //null 只要输出为null 意思是类加载器使用的是引用类加载器
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//       根据线程上下文对象获取 当前线程是CLassLoaderTest类 所以为默认类加载器 也就是应用类加载器
     System.out.println(Thread.currentThread().getContextClassLoader()); //sun.misc.Launcher$AppClassLoader@b4aac2


    }

}
