package com.misaka.java.middle;

public class invokeTest {
    static class Father{
//        父类方法 并且未被重写 invokespecial
        public void FatherWay(){
            System.out.println("Father");
        }
        /*父类方法并且重写 无静态绑定
        *    invokevirtual*/
        public void FatherRe(){
            System.out.println("F RE");
        }
    }
    static class Son extends Father{
//        子类自带的方法 invokevirtual
        public void SonWay(){
            System.out.println("Son");
        }

        @Override
        public void FatherRe() {
            super.FatherRe();
            System.out.println("Son re");
        }
        private void S(){
            System.out.println("Test");
        }

    }
    public static void main(String[] args) {
//        创建子对象
        Son son =new Son();
//        调用父类方法
        son.FatherWay();
//        调用父类重写方法
        son.FatherRe();
//        调用自带
        son.SonWay();
        son.S();
    }
}
