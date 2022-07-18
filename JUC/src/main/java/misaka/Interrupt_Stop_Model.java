package misaka;

public class Interrupt_Stop_Model {
    private static volatile boolean state = false;

    public static void main(String[] args) {
//        老办法 通过interrupt来实现
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("料理后事");
                    break;
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

//        新办法 通过可见性来实现
        Thread t2 = new Thread(() -> {
            while (true) {
//                原子性保证数据的修改所有的线程都可见
                if (state) {
                    System.out.println("料理后事");
                    break;
                }
            }
        });
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        state=true;
    }
}
