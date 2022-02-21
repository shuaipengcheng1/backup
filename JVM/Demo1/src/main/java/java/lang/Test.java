package java.lang;

public class Test {
    static {
//        没有被初始化 因为没有输出
        System.out.println("hello");
    }
    public static void main(String[] args) {
//        直接报错 因为沙箱安全机制
        System.out.println("xxx");
    }
}
