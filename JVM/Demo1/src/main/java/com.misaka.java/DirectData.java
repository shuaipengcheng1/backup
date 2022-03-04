package com.misaka.java;

import java.nio.ByteBuffer;
import java.util.Scanner;

public class DirectData {
    //    直接内存
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        byteBuffer = null;
        scanner.next();


    }
}
