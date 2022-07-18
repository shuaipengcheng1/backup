package misaka.Product_Constomer_MainTain;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MiddleWear {
    //    线程中间类 用于存放 guardObject 每一个Object 对应一个要传递的线程
//    结果线程 和 获取线程 要一一绑定
    ConcurrentHashMap<String, GuardObject> map = new ConcurrentHashMap<>();

    static class GuardObject {
        //       守护类
        private int id;
        private Object result;

        public GuardObject() {
        }

        public GuardObject(int id) {
            this.id = id;
        }

        //    get方法 等待结果线程
        public void get() {
            synchronized (this) {
//            将当前Owner线程放入monitor的WaitSet中
                while (result == null) {
                    System.out.println(Thread.currentThread().getName() + "开始等待");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "获取到结果"+this.result);
            }
        }

        //    设置结果线程
        public void Set(Object re) {
            synchronized (this) {
                this.result = re;
//        唤醒
                this.notifyAll();
            }
        }
    }
}
