package misaka.SellTicketTest;

public class SellWindows {
//    模拟售票窗口

    //    设为私有属性
    private Integer num;

    //初始化
    public SellWindows(int num) {
        this.num = num;
    }

    //    获取余票
    public void getNum() {
        System.out.println(num);
    }

    //    买票
//    有线程安全问题
//    1 num为共享对象
    public int UnSafeSell(int Account) {

        if (num >= Account) {
            num -= Account;
//            System.out.println(Thread.currentThread().getName()+"购买成功"+"余票"+num);
            return Account;
        } else {
            return 0;
        }


    }

    //    解决 加上一个线程锁
    public synchronized int Sell(int Account) {

        if (num >= Account) {
            num -= Account;
//            System.out.println(Thread.currentThread().getName()+"购买成功"+"余票"+num);
            return Account;
        } else {
            return 0;
        }


    }
}
