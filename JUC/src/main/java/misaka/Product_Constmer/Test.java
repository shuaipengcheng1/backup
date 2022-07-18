package misaka.Product_Constmer;

public class Test {
    //线程A 等待 线程B的答案
    public static void main(String[] args) {
//        公用一个对象
        GuardObject guardObject = new GuardObject();
        new Thread(() -> {
//            等待
            Object o = guardObject.get();
            System.out.println(o);
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            设置结果
            guardObject.set(10);
        }).start();

    }

    static class GuardObject {
        private Object result;

        //    等待获取对象
        public Object get() {
            synchronized (this) {
                while (result == null) {
                    try {
//                        将当前的线程 放入WaitSet集合 等待
                        this.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//            返回
                return result;

            }

        }

        //        获取结果
        public void set(Object o) {
            synchronized (this) {
//                设置条件
                this.result = o;
//                唤醒所有的WaitSet中的线程到EntrySet
                this.notifyAll();
            }
        }
    }
}
