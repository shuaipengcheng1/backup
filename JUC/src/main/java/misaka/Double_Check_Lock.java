package misaka;

public class Double_Check_Lock {
    //    DCL
    static volatile boolean a = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
//            DCl();
            No_Dcl();

        });
        Thread t2 = new Thread(() -> {
//            DCl();
            No_Dcl();
        });

        t1.start();
        t2.start();
    }

    public static void DCl() {
        if (!a) {       // 在锁的外部进行判断 防止每次都进入锁内部 CAS
            synchronized (Double_Check_Lock.class) {
                if (!a) {
                    a = true;
                }
            }
        } else {
            System.out.println(a);
        }
    }

    public static void No_Dcl() {
        synchronized (Double_Check_Lock.class) {  //没有采用DCL设计模式 每一次线程进入方法体都会CAS
            if (!a) {
                a = true;
            } else {
                System.out.println(a);

            }
        }
    }
}
