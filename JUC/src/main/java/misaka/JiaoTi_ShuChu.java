package misaka;

public class JiaoTi_ShuChu {
//    交替输出 让三个线程分别输出 a b c 都输出5次
//    最后结果 abcabcabcabcabc
    public static void main(String[] args) {
//          1 A 2 B 3 C
       ExPrint exPrint = new ExPrint();
       new Thread(()->{
           exPrint.Print("a",1,2);
       }).start();
        new Thread(()->{
            exPrint.Print("b",2,3);
        }).start();
        new Thread(()->{
            exPrint.Print("c",3,1);
        }).start();
    }



    static class ExPrint{
//        默认当前标记为1
        static int Flag=1;
//                         循环5次
        static int Loop =5;
        public void Print(String str,int isFlag,int NextFlag){
//            给类加锁
            synchronized (this){
                for (int i = 0; i < Loop; i++) {
                    // 当前的标记 和 要输出的标记不一致
                    while (Flag!=isFlag){
//                    不相等
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                相等 修改当前的值
                    Flag =NextFlag;
//                    输出
                    System.out.print(str);
//                叫醒其他线程
                    this.notifyAll();
                }
            }
        }
    }
}
