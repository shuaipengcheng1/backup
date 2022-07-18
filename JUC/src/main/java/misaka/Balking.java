package misaka;

public class Balking {

    private static  volatile  boolean state =false;
    static Object o = new Object();
//    犹豫模式
public static void main(String[] args) {
    Thread t1  = new Thread(()->{
      synchronized (o){ //线程锁 因为不排除两个线程都用时操作state的情况 可见性不保证原子性 所以线程不安全
          if(state){
//              不允许多线程
              return;
          }else {
              state=true;

              System.out.println(Thread.currentThread().getName()+"允许");
          }
      }
    });
    Thread t2 = new Thread(()->{
        synchronized (o) {
            if (state) {
//              不允许多线程
                return;
            } else {
                state = true;

                System.out.println(Thread.currentThread().getName() + "允许");
            }
        }
    });
    t1.start();
    t2.start();
}
}
