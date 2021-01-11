package basic;

import java.util.concurrent.Semaphore;

/**
 * @author mhh
 * @since 2021/1/11
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
//        Semaphore semaphore = new Semaphore(0);
//        new Thread(() -> {
//            System.out.println("线程1等待信号量");
//            try {
//                semaphore.acquire();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("线程1获得了信号量");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            semaphore.release();
//            System.out.println("线程1释放信号量");
//        }).start();
//        semaphore.release();
//        Thread.sleep(500);
//        System.out.println("主线程尝试获取信号量");
//        semaphore.acquire();
//        System.out.println("主线程得到了信号量");
        unfairTest();
    }

    static void unfairTest() throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        new Thread(() -> {
            try {
                semaphore.acquire(3);
                System.out.println("线程1抢到了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);
        new Thread(() -> {
            try {
                semaphore.acquire(2);
                System.out.println("线程2抢到了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        System.out.println("主线程释放两个资源");
        semaphore.release(1);
    }
}
