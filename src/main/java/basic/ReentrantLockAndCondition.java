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
        case2();
    }

    /**
     * 重入锁主要流程
     */
    public static void case1() {
        ReentrantLock reentrantLock = new ReentrantLock();
        //加锁
        reentrantLock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            reentrantLock.unlock();
        }
    }

    /**
     * unlock异常
     */
    public static void case2() {
        ReentrantLock reentrantLock = new ReentrantLock();
        //加锁
        reentrantLock.lock();
        new Thread(() -> {
            //会抛出异常 执行unlock的线程必须当前拥有锁
            reentrantLock.unlock();
        }).start();
    }
}
