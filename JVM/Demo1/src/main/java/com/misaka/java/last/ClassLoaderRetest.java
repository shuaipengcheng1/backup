package com.misaka.java.last;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClassLoaderRetest extends ClassLoader{
    //    自定义类加载器

    public ClassLoaderRetest(String URL) {
        this.URL = URL;
    }

    String URL;

    public ClassLoaderRetest() {
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        定义路径
        String Path = URL+name+".class";
        FileInputStream fileInputStream=null;
        ByteArrayOutputStream arrayOutputStream=null;
        try {
            //        输出流
          fileInputStream = new FileInputStream(Path);
//          输入流
            arrayOutputStream = new ByteArrayOutputStream();
//            每次读取的字节大小
            byte[] data = new byte[1024];
//            每一次的读取长度
            int len;
            while (true){
                try {
//                    判断读取值
                    if (((len=fileInputStream.read(data))!=-1)) {
                 arrayOutputStream.write(data,0,len);
                    }
//                    转为byte数组
                   byte[] bytes =  arrayOutputStream.toByteArray();
//                   将二进制class文件 给到类加载器 生成CLass对象再内存中
                return     defineClass(null,bytes,0,bytes.length);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileInputStream!=null)
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(arrayOutputStream!=null)
                    arrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
