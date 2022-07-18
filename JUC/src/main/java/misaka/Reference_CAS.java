package misaka;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class Reference_CAS {
    public static void main(String[] args) {
        Account  account = new Account();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 500 ; i++) {
                account.update(new BigDecimal(10));

            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i <500 ; i++) {
                account.update(new BigDecimal(10));

            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance());
    }
    static class Account {
//      账户
//      不是线程安全的
//   static BigDecimal balance = BigDecimal.valueOf(10000);

       private static final AtomicReference<BigDecimal> balance = new AtomicReference<>(new BigDecimal(100));

        public  AtomicReference<BigDecimal> getBalance() {
            return balance;
        }

        public void update(BigDecimal i) {
//            while (true) {
//                BigDecimal prev = balance.get();
//                BigDecimal after = prev.add(i);
//                if(balance.compareAndSet(prev,after)){
//                    break;
//                }
//            }
//            这上面两个是一样的
            balance.updateAndGet(x->x.add(i));
            
        }
    }
}

