package com.misaka.java.last;

import java.util.HashSet;

public class HashCodeError {
//    重写哈希 导致的内存泄漏
public static void main(String[] args) {
    HashSet hashSet = new HashSet();
    cc cc = new cc(20); // hashcode 40
    hashSet.add(cc); // 存储在 40
    cc.setNum(40); //hashcode 80 因为该值与hashcode算法相关
  boolean b=  hashSet.remove(cc); //false
  System.out.println(b+""+hashSet.size());// size==1  因为hashSet 是通过哈希值来获取元素的 如果重写了 就无法再获取到对应的元素 所以无法删除
}

static class  cc{
//
  int num;

    public cc(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        return this.num*2;
    }
}

}
