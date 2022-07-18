package misaka;

public class ThreadSafe {
//    线程安全问题
//    分时系统
    static Integer re =0;
public static void main(String[] args) {
    Thread t2 = new Thread(()->{
//        安全解决方法 线程锁

//         当t2先在使用re时 re不会释放 所以t1线程无法执行 要等待t2执行完毕
//        如果t1先使用 则t2等待t1结束
        synchronized (re){
            //        做+法;
            int r=re+1;
//        这时去做Sleep阻塞 t1会返回-1 但是这里的++值 还是0++的值 为1 所以最后主线程获得的值 不是期望的-1+1=0 而是 0+1=1
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            re=r;
        }

    });

    Thread t1 = new Thread(()->{
        synchronized (re){
            //        做减法
            int r = re-1;
            re=r;
        }

    });
    t2.start();
    t1.start();
//    输出 正确为0 错误为1
    try {
//        同步
        t2.join();
        t1.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println(re);

}
}
