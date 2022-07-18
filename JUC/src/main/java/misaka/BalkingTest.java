package misaka;

public class BalkingTest {
//    doinit() 只能被调用一次

public static void main(String[] args) {
    Test test = new Test();
    Thread t1 = new Thread(test::doinit);
    Thread t2 = new Thread(test::doinit);
    Thread t3 = new Thread(test::doinit);

    t1.start();
    t2.start();
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    t3.start();
}
static class Test{
//    保证可见性 有序性
 volatile boolean state=false;
// 使用 DCL(Double check lock)设计模式 增加效率
 public void doinit(){
     if(!state){
         synchronized (this){ //保证原子性 可见性 有序性
             if(!state){
                 System.out.println("允许");
                 state=true;
             }else {
                 System.out.println("禁止1");

             }
         }
     }else {
         System.out.println("禁止2");

     }
 }
}
}
