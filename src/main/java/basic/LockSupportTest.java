package basic;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println();
            //设置标志位是true
            Thread.currentThread().interrupt();
            //清除标志位
            Thread.interrupted();
            System.out.println(Thread.currentThread().isInterrupted());
            LockSupport.park();
            LockSupport.park();
            System.out.println("解除park状态");
        });
        thread.start();
        Thread.sleep(1000);
        LockSupport.unpark(thread);
    }
}
