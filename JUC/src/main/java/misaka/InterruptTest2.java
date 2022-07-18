package misaka;

public class InterruptTest2 {
    public static void main(String[] args) {
           Threads threads = new Threads();
           threads.start();
//           等待100ms 调用关闭线程 测试在睡眠时 关闭线程的情况
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threads.end();
        /*
        *
        *
        * sleep
         java.lang.InterruptedException: sleep interrupted [睡眠时打断]
         	at java.lang.Thread.sleep(Native Method)
         	at misaka.InterruptTest2$Threads.lambda$start$0(InterruptTest2.java:36)
         	at java.lang.Thread.run(Thread.java:748)
         睡眠时打断  // 重新设置打断状态
         打断了 // while true 退出
        *
        * */
    }
    //监控线程类
    static class Threads{
//  创建一个线程对象
     private    java.lang.Thread moniter;
//        启动线程
        public void start(){
            moniter = new java.lang.Thread(()->{
                java.lang.Thread thread = java.lang.Thread.currentThread();
                while (true){
//                    System.out.println(thread.isInterrupted());
//                 判断是否打断
                   if(thread.isInterrupted()){
//                       打断了
                       System.out.println("打断了 这里可以做死亡生命周期");
                       break;
                   }else {
                       System.out.println("sleep");

//                       没打断
                       try {
//                           睡眠
                           java.lang.Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
//                           防止眠时打断
                           System.out.println("睡眠时打断");
//                           重新设置打断状态
                           thread.interrupt();
                       }
                   }
                  }
            });
            moniter.start();

        }
        //            打断线程
         public void end(){
            moniter.interrupt();
         }

    }
}

