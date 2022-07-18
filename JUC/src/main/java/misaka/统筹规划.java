package misaka;

public class 统筹规划 {
//    洗水壶
    static boolean xiShuiHU =false;
//    烧开水
    static boolean KaiShui =false;
//    洗茶壶 茶杯 茶叶
    static boolean Action=false;
//    创建两个线程
public static void main(String[] args) {
    Thread t1 = new Thread(()->{
        System.out.println("洗水壶");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("洗水壶OK");
        xiShuiHU=true;
        System.out.println("烧开水");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        KaiShui=true;
        System.out.println("烧开水ok");


    });
    Thread t2 = new Thread(()->{
        System.out.println("洗茶壶 洗茶杯..");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("洗茶壶 洗茶杯.. OK");
        Action=true;
    });
    t1.start();
    t2.start();
//    等待时间较长的线程
    try {
        t1.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    if(KaiShui&&Action&&xiShuiHU){
        System.out.println("泡茶");
    }
}
}
