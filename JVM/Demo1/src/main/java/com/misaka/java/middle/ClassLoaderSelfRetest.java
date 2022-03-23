package com.misaka.java.middle;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClassLoaderSelfRetest extends ClassLoader{
    private String URL;
//    接收要扫描的文件夹路径
    public ClassLoaderSelfRetest(String URL){
        this.URL = URL;
    }
//   重写findclass方法 loadClass方法不同重写 因为重写loadClass文件 需要重写双亲委派机制


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//     将路径拼接起来
        String Path = URL+name+".class";
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
//        创建一个文件读取流
        try {
           fileInputStream  = new FileInputStream(Path);
           byteArrayOutputStream = new ByteArrayOutputStream();
//           读取
            int len;
            byte[] bytes = new byte[1024];
            while (true){
                try {
                    if (((len=fileInputStream.read(bytes))!=-1)) {
                        System.out.println("读取的文件长度"+len);
                        byteArrayOutputStream.write(bytes,0,len);
                    }
//                    将byteArrayOutputStream转为数组
                  byte[] Data=  byteArrayOutputStream.toByteArray();
//                    通过字节码二进制流 来创建对应的class文件
                    return defineClass(null,Data,0,Data.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }else {
                    throw new RuntimeException("文件读取流错误");
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }else {
                    throw new RuntimeException("文件输出流错误");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
return null;
    }
}
