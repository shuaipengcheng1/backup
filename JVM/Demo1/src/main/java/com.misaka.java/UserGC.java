package com.misaka.java;

public class UserGC {
//    测试GC
//    查看当前的GC
//    -XX:+PrintCommandLineFlags
//    设置为serialGC(串行)
//    -XX:+UseSerialGC 标识新生代使用SerialGC 老年代使用SerialOldGC
//    -XX:+UseParNewGC(并行) 标识新生代使用 ParNew 老年代使用 Serial Old
//    -XX:+UseConcMarkSweepGC(并发) 启用CMS
//    -XX:+UseG1GC(并发 分区算法 堆区综合回收)
public static void main(String[] args) {
    try {
        Thread.sleep(10000000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
