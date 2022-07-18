package misaka;

public class LiveLock {
//    活锁
    static Integer count=10000;

    public static void main(String[] args) {

        new Thread(()->{
            synchronized (count){
                while (count>0){
                    count++;
                    System.out.println(count);
                }
            }
        }).start();
        new Thread(()->{
            synchronized (count){
                while (count>0){
                    count--;
                    System.out.println(count);

                }
            }
        }).start();

    }
}
