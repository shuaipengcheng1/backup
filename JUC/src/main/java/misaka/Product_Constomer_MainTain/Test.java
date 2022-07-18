package misaka.Product_Constomer_MainTain;

public class Test {
    public static void main(String[] args) {
//        创建6个线程 三个收集 三个发送 通过中间件存储
        MiddleWear middleWear = new MiddleWear();
        Thread t1 = new Thread(() -> {
//            创建一个线程对象 在中间件中 id 为 当前线程名字
//            MiddleWear.GuardObject guardObject = new MiddleWear.GuardObject();
            middleWear.map.put(Thread.currentThread().getName(), new MiddleWear.GuardObject());
            middleWear.map.get(Thread.currentThread().getName()).get();
        }, "t1");
  t1.start();
    
        Thread t1_support=new Thread(()->{
            while (middleWear.map.size()==0){

            }
//            获取中间件中对应的Guard对象
           MiddleWear.GuardObject guardObject= middleWear.map.get("t1");
//           设置返回值
            guardObject.Set(10);
        },"T1_Supprot");
        t1_support.start();


    }
}
