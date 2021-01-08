package basic;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {
        case1();
    }

    static void case1() {
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park(Thread.currentThread());
        System.out.println("第一次没park住");
        LockSupport.park(Thread.currentThread());
        System.out.println("第二次没park住");
    }
}
