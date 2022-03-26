package com.misaka.java.last;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClassLoderSelfTest extends ClassLoader{
//    路径
    String URL;

    public ClassLoderSelfTest(String URL) {
        this.URL = URL;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        拼接链接
        String Path = URL+name+".class";
        FileInputStream fileInputStream=null;
        ByteArrayOutputStream arrayOutputStream=null;
        try {
            //        创建输出流

            fileInputStream= new FileInputStream(Path);
//            创建字节输入流
            arrayOutputStream= new ByteArrayOutputStream();
//            每一次字节的输入的长度
            int len;
//            每一次读取的byte长度
            byte[] bytes = new byte[1024];
            while (true) {
                try {
                    while ((len=fileInputStream.read(bytes))!=-1){
                        arrayOutputStream.write(bytes,0,len);
                    }
                   byte[] data= arrayOutputStream.toByteArray();
//                    通过二进制字节流 获取Class对象
                  return   defineClass(null,data,0,data.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
