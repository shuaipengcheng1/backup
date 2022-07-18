package misaka;

import java.util.concurrent.locks.LockSupport;

public class JiaoTI_Shuchu3 {
    static  Thread t1 ;
    static  Thread t2;
    static  Thread t3;
    public static void main(String[] args) {
       Park park = new Park();
       t1 = new Thread(()->{
          park.Print("a",t2,1,2);
       });
       t2=new Thread(()->{
           park.Print("b",t3,2,3);

       });

        t3=new Thread(()->{
            park.Print("c",t1,3,1);

        });
        t1.start();
        t2.start();
        t3.start();



    }




    //    使用 ParkUnpark 解决 交替输出问题
    static class Park {
        static int loop = 5;
        static int index = 1;

        //        Park的情况
        /*
         * str 要打印的字符
         * nextThread 下一条线程
         * */
        public void Print(String str, Thread nextThread, int isindex, int nextIndex) {
            for (int i = 0; i <loop ; i++) {
                while (index != isindex) {
//                不相等
//            暂停当前的线程
                    LockSupport.park();
                }
//            输出
                System.out.print(str);
                index = nextIndex;
//            解锁下一个线程
                LockSupport.unpark(nextThread);

            }

        }
    }
}
