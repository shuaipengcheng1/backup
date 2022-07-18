package misaka;

public class JoinTest {
    //    测试 等待t1线程结束后 再运行main线程
    static int i = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
//        睡眠线程
            try {
                Thread.sleep(Long.parseLong("200"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            i = 10;
        }, "t1");
        t1.start();
//    暂停main线程 等待t1结束
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//    输出i
        System.out.println(i);//10
    }
}
