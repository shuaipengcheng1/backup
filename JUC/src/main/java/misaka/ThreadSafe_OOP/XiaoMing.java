package misaka.ThreadSafe_OOP;

public class XiaoMing {
    //    --
    public void Sub(Goods goods){
//       加线程锁
        for (int i = 0; i < 5000; i++) {
            synchronized (goods){
                goods.price--;
            }
        }
    }
}
