package com.misaka.java;

public class Extend {
   static class Father{
        int id=10;
        public Father(){
            this.Say(); //这里的this为son id还没有赋值[因为子类直接调用的是父类的init方法 没有链接阶段] 所以为0

            this.id=10;
        }
        public void Say(){

            System.out.println("Father say"+id);
        }
    }
   static  class Son extends Father{
        int id=20;
        public Son(){
            this.Say();
            this.id=10;
        }
        @Override
        public void Say() {
            System.out.println("Son Say"+id);
        }
    }

    public static void main(String[] args) {
//       多态 创建Son
      Father father =new Son();
//      根据类加载过程的 加载阶段 连接阶段 和 初始化阶段(调用init)
//        在初始化阶段中父类初始化将快于子类初始化
//        Son类会调用Father的<init>[实例化]方法
//        所以第一个输出为
        // Son say 0
//        第二个输出 是实例化子类自己的对象
//        调用的this.Say() 这里的this肯定为Son
//        然后由于Son不是直接跳转到的init方法 所以在链接阶段时 就已经将id设置为20了
//        所以第二个输出为 Son say 20

//        类赋值优先级 初始化默认值[连接阶段]-->显式赋值[链接阶段]-->init方法赋值-->外部通过. 赋值
     father.Say();//这里创建的对象是Son对象 id为10  Son say 10

    }
}
