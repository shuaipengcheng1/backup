package misaka;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class JiaoTi_Shuchu2 {
//    使用ReentrantLock 实现 通过三个Condition来实现
   static ReentrantLock lock= new ReentrantLock();
    static Condition A = lock.newCondition();
    static Condition B = lock.newCondition();
    static Condition C = lock.newCondition();

    public static void main(String[] args) {
        List<Condition> list  =new Vector<>();
        list.add(A);
        list.add(B);
        list.add(C);
        ExPrint exPrint = new ExPrint(lock);
        Thread t1 = new Thread(()->{
            exPrint.Print("a",list,1,2);
        });
        Thread t2 = new Thread(()->{
            exPrint.Print("b",list,2,3);

        });
        Thread t3 = new Thread(()->{
            exPrint.Print("c",list,3,1);

        });
        t1.start();
        t2.start();
        t3.start();
    }

    //    还是通过123 标注

    //    面向对象写法
    static class ExPrint {
        ReentrantLock lock ;
        //        默认开始的下标
        static int index = 1;
        static int Loop = 5;

        public ExPrint() {
        }

        public ExPrint(ReentrantLock lock) {
            this.lock = lock;
        }

        /*
         * str 当前的字符串
         * condition 标识每一个WaitSet
         * isIndex 当前的字符串的标识
         * NextIndex 下一个字符的标识
         * */
        public void Print(String str, List<Condition> condition, int isIndex, int NextIndex) {
            for (int i = 0; i < Loop; i++) {
                //     循环内部上锁 防止 多线程同时运行循环内部
                // 如果在循环外部上锁 就有可能会同时运行循环内部

                lock.lock();

//                  判断当前
                while (isIndex != index) {
                    try {
//                        await方法不能多线程同时调用 否则会报错
                        condition.get(isIndex - 1).await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                相等
                System.out.print(str);
                for (Condition item : condition
                ) {
//                    唤醒每一个Condition
                    item.signalAll();

                }
//                更新下标
                index=NextIndex;
                //                    解除锁
                lock.unlock();
            }
        }
    }
}
