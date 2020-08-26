package basic;

import java.util.concurrent.locks.Condition;
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
        ReentrantLock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();

        Thread thread = new Thread(() -> {
            lock.lock();
//            lock.unlock();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            lock.unlock();
//            lock.lock();
            while (true){

            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            lock.lock();
            while (true) {
            }
        });
        thread1.start();
//        Thread.sleep(100);
//        thread1.interrupt();
        Thread thread2 = new Thread(() -> {
            lock.lock();
            while (true) {
            }
        });
        thread2.start();
        while (true) {

        }
    }
}
