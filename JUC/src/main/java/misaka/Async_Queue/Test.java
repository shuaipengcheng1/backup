package misaka.Async_Queue;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
//        创建一个消息队列
        MessageQueue messageQueue = new MessageQueue();
        //        一个消费者线程 监视队列
        new Thread(messageQueue::take, "Consumer").start();
//        创建三个生产者线程
        new Thread(() -> {
            messageQueue.put(new Message(1, Thread.currentThread().getName()));
        }, "t1").start();
        new Thread(() -> {
            messageQueue.put(new Message(2, Thread.currentThread().getName()));

        }, "t2").start();
        new Thread(() -> {
            messageQueue.put(new Message(3, Thread.currentThread().getName()));

        }, "t3").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            messageQueue.put(new Message(3, Thread.currentThread().getName()));

        }, "t4").start();

    }

    //    消息队列类
    static class MessageQueue {
        //        一个队列 多线程操作 需要考虑线程安全
        static final List<Message> list = new Vector<>();

        //    放入消息
        public void put(Message message) {
            synchronized (list) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("放入信息");
//                设置最大的长度
                while (list.size() == 5) {
                    System.out.println("消息队列已满等待");
                }
                list.add(message);
//                唤醒
                list.notifyAll();

//        排序
                Collections.sort(list);
            }

        }

        //    消费消息

        public void take() {
            synchronized (list) {
                System.out.println("消费者start");
//        消费优先级最高的消息
                while (list.size() == 0) {
                    System.out.println("消息队列中无消息~~~");
                    try {
//                        等待
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (list.size() != 0) {
                        Message message = list.remove(0);
                        System.out.println(message.ThreadName + "发的消息被消费了");
                    }
                }


            }
        }
    }

    // 消息类
    static class Message implements Comparable<Message> {
        int id; //优先级
        String ThreadName; //生产者的名字

        public Message(int id, String threadName) {
            this.id = id;
            ThreadName = threadName;
        }

        @Override
        public int compareTo(Message o) {
            if (o.id > this.id) {
                return 1;
            } else {
                return 0;

            }
        }
    }
}
