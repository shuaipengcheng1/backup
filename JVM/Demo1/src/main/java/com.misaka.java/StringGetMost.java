package com.misaka.java;

import java.util.Arrays;
import java.util.Scanner;

public class StringGetMost {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
//        Map map = new IdentityHashMap();
        byte[] bytes = s.getBytes();
//        System.out.println(Arrays.toString(bytes));
        int status = 0;
        int[] arr = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
//            出现次数
            status = 0;
            byte key = bytes[i];
            for (int j = 0; j < bytes.length; j++) {
                if (bytes[j] == key) {
                    ++status;
                }
                if (j == bytes.length - 1) {
//                    加入值
                    arr[i] = status;
                }
            }
        }
        StringBuilder chars = new StringBuilder();
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

//        System.out.println(Arrays.toString(arr));

        int ix = 0;
        while (ix < arr.length) {
            if (arr[ix] > max) {
                max = arr[ix];
                status = max;
//                System.out.println(Arrays.toString(bytes));
                //                判断值是否重复 indexof(str) 判断该字符在stringBuilder中最后出现的坐标 如果没有则是-1
                if (chars.indexOf(String.valueOf((char) bytes[ix])) == -1) {
//                    第一次
                    chars.append((char) bytes[ix]);

                }
            }
            if (arr[ix] == max) {
                max = arr[ix];
                status = max;
//                判断值是否重复 indexof(str) 判断该字符在stringBuilder中最后出现的坐标 如果没有则是-1
                if (chars.indexOf(String.valueOf((char) bytes[ix])) == -1) {
//                    第一次
                    chars.append((char) bytes[ix]);

                }
            }
            ++ix;
        }

//System.out.println(chars);
        System.out.print(chars);
        System.out.print("\n");
        System.out.print(status);

    }
}
//            记录
//            map.put(status,key);

//System.out.println();
//        循环map
//        Set<Map.Entry<Object, Object>> m = map.entrySet();
//        for (Map.Entry<Object, Object> item : m) {
////            String s1 =String.valueOf(item.getValue()) ;
//            String s1=String.valueOf(item.getValue());
//            int i = Integer.parseInt(s1);
//            char c = (char) i;
//            System.out.println(c);
//            System.out.println(item.getKey());
//            return;
//
//        }



