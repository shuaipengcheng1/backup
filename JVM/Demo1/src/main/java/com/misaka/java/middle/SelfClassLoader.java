package com.misaka.java.middle;

import java.io.*;

public class SelfClassLoader extends ClassLoader{
    /*
    * 自定义类加载器
    * */
String url ;

    public SelfClassLoader( String url) {

        this.url = url;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        获取CLass文件路径
        String URL =url+name+".class";
//   读取数据流
        BufferedInputStream inputStream=null;
//        写入数据流
        ByteArrayOutputStream byteArrayOutputStream =null;
        try {
            inputStream= new BufferedInputStream(new FileInputStream(URL));
           byteArrayOutputStream= new ByteArrayOutputStream();
//           读取的长度记录 用于后续放入
            int len;
//            一次读取的长度
            byte[] bytes = new byte[1024];
//            inoutSteam.read() 返回值是读取的长度 如果没有 则返回-1
            while ((len=inputStream.read(bytes))!=-1){
//                将读取的数据放入byte读取流 第一个参数是要放入的数据 第二个是起始下标 地三个是结束下标
                byteArrayOutputStream.write(bytes,0,len);


            }
            System.out.println(byteArrayOutputStream.size());
//            获取一个byte数组
          byte[] Data=  byteArrayOutputStream.toByteArray();
//          调用defineClass 将字节码文件的二进制流放入 它会返回一个Class对象
        return     defineClass(null,Data,0,Data.length);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
