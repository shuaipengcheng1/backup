package misaka;

public class WaitTest {
    static Integer re =0;

    //    等待测试
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {


            synchronized (re){
                //        线程1
                try {
                    re.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1 is running"+re);
            }




        });
        Thread t2 = new Thread(() -> {
            synchronized (re){
                //      线程2
                System.out.println("线程2 is Stop");
                try {
                    re.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }});
            t2.start();
            t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       synchronized (re){
//要调用对象的wait notify... 等方法 需要先获取该对象的锁
//           然后再调用 因为wait会将锁直接升级为monitor(重量级锁) 以便于获取WaitSet
//           wait()方法就是将当前的线程 放入当前Owner锁对应的moniter对象的waitSet中
//           如果想要唤醒 就需要另一个线程 也获取对应的锁对象 调用notify唤醒 对应的Monitor对象的waitSet的线程
           re.notifyAll();
       }
        System.out.println(re);

    }
}

