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
        case4();
    }

    /**
     * 重入锁正常流程
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

    /**
     * lock响应中断
     */
    public static void case3_1() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        Thread thread = new Thread(() -> {
            System.out.println("开始等待锁");
            reentrantLock.lock();
            System.out.println("抢到锁");
        });
        thread.start();
        thread.interrupt();
        Thread.sleep(5000);
        reentrantLock.unlock();
        System.out.println("主线程释放锁");
    }

    /**
     * lockInterruptibly响应中断
     *
     * @throws InterruptedException
     */
    public static void case3_2() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        Thread thread = new Thread(() -> {
            System.out.println("抢占锁");
            try {
                reentrantLock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("lockInterruptibly响应中断");
                e.printStackTrace();
            }

        });
        thread.start();
        thread.interrupt();
        Thread.sleep(5000);
        reentrantLock.unlock();
        System.out.println("主线程释放锁");
    }

    /**
     * Condition测试
     */
    public static void case4() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                reentrantLock.lock();
                System.out.println("thread1获得锁");
                condition1.await();
                System.out.println("condition1停止等待");
                reentrantLock.unlock();
            } catch (InterruptedException e) {
                System.out.println("condition1被中断");
                e.printStackTrace();
            }
        });


        Thread thread2 = new Thread(()->{
            reentrantLock.lock();
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        });
        thread2.start();
        System.out.println("先执行线程2");

        thread1.start();
        System.out.println("再执行线程1");
        Thread.sleep(100);
        reentrantLock.lock();
        condition1.signal();
        reentrantLock.unlock();
    }
}
