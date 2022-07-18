package misaka;

public class ThreadSafe_Method {
    public static void main(String[] args) {
        Te te = new Te();
        Thread t1 = new Thread(()->{
            for (int i = 0; i <5000 ; i++) {
//                te.xx();
                te.xxx();

            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i <5000 ; i++) {
//                te.yy();
                te.yyy();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(te.i);
    }
    static class Te{
        int i=0;
        public synchronized void xx(){
//            xx yy等于锁住this 线程t1进来锁住this 因为t1 t2 都是用同一个实例对象调用的该方法[xx yy] 所以满足锁一致 可以锁住
            i++;
        }
        public synchronized void yy(){
            i--;
        }
        public void xxx(){
            synchronized (this){
                i++;
            }
        }
        public void yyy(){
            synchronized (this){
                i--;
            }
        }
    }
}
