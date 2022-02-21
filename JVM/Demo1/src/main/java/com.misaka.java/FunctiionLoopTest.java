package com.misaka.java;

public class FunctiionLoopTest {


    public static void main(String[] args) {
        Loop(0);
    }
    public static void Loop(int i){
        if(i!=10){
            Loop(++i);
            System.out.println("嵌套返回"+i);
        }else {
            System.out.println("嵌套结果成功"+i);
//            模拟双亲委派机制 在父类时找到了
//            throw new RuntimeException("成功");
            System.exit(0); //如果找到了直接退出  嵌套结果成功10
        }

    }

 /*
嵌套结果成功10
* 嵌套返回10
嵌套返回9
嵌套返回8
嵌套返回7
嵌套返回6
嵌套返回5
嵌套返回4
嵌套返回3
嵌套返回2
嵌套返回1
*
*
* */
}
