package basic;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author mhh
 * @since 2020/8/20
 */
public class OtherTest {


    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
        lock.readLock().lock();
        System.out.println("main read lock");

        new Thread(() -> {
            lock.readLock().lock();
            System.out.println("thread read lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.readLock().lock();
            System.out.println("thread read lock again");

            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.readLock().unlock();
            lock.readLock().unlock();
        }).start();

        Thread.sleep(100);

        new Thread(() -> {
            System.out.println("before thread write lock");
            lock.writeLock().lock();
            System.out.println("thread write lock");
            lock.writeLock().unlock();
        }).start();
    }

    static void case1() {
        Thread thread1 = new Thread(() ->{
            while (true){

            }
        });
        Thread thread2 = new Thread(() ->{
            while (true){

            }
        });

    }

}
