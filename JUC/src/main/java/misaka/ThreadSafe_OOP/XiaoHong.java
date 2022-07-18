package misaka.ThreadSafe_OOP;

public class XiaoHong {
//    加加
    public void Add(Goods goods){
//       加线程锁
        for (int i = 0; i < 5000; i++) {
//            锁住Goods对象 并在内部操作 goods.price++
            synchronized (goods){
                goods.price++;
            }
        }
    }
}
