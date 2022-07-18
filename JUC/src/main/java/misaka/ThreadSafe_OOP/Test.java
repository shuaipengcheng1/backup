package misaka.ThreadSafe_OOP;

public class Test {
    //    线程安全 改进为 面向对象编程
//    将数据抽象为 小红 小明 内部操作GOODS.Price
//    创建两个线程对象 分别运行++ --
    static Goods goods = new Goods(0);
    static XiaoHong xiaoHong = new XiaoHong();
    static XiaoMing xiaoMing = new XiaoMing();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            xiaoHong.Add(goods);
        });
        Thread t2 = new Thread(() -> {
            xiaoMing.Sub(goods);
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(goods.price); //0
    }
}
