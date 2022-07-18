package misaka;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(()->{
//
            System.out.println("t1");
            return 100;
        });
//        使用Thread对象 运行
        Thread t1 = new Thread(futureTask,"t1");

        t1.start();
        try {
            try {
//                等待该线程的返回结果
                System.out.println(futureTask.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
