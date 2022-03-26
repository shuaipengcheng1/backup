package com.misaka.java.last;

public class DeadLock_Last {
    static class Credit_Card{
        String id ="10";
        String value="20";
        public void UseId(){
            //            锁住id
            synchronized (this.id){
                System.out.println("");
              this.UseValue();
            }
        }
        public void UseValue(){
//            锁住value
            synchronized (this.value){
            this.UseId();
            }
        }
    }
//    模拟死锁
public static void main(String[] args) {
        Credit_Card credit_card = new Credit_Card();
    Thread t1 = new Thread(()->{
    credit_card.UseId();
    });
    Thread t2 =new Thread(()->{
        credit_card.UseValue();
    });
    t1.start();
    t2.start();
}
}
