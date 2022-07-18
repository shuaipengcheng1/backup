package misaka;

public class 可见性测试 {
    //    创建一个布尔值的变量 用于循环
   volatile static boolean r = true;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (r) { //读取
            }
        });
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r = false; // 这里不会停下while

    }

    /*
    * JMM 工作流程
    *  1 首先 t线程从主内存中读取了r的值[r是一个静态成员变量 存储在方法区内存 ]到工作内存中
    *  2 由于t线程频繁的读取了r的值 所以JIT(即时编译器) 将其列为热点代码 所以将其的值缓存到方法区中 以便于下次直接访问 减少对主存的调用 减少调用
    * */

}
