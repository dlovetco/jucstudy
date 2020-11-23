package basic;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁+Condition
 * 用来代替synchronize+wait notify 提升代码可读性
 *
 * @author mhh
 * @since 2020/8/20
 */
public class ReentrantLockAndCondition {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            System.out.println("11123");
            try {
                Thread.sleep(500);
                System.out.println("结束sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            System.out.println("线程2开始抢锁");
            lock.lock();
            System.out.println("9999");
        }).start();
        System.out.println(123);
    }
}
