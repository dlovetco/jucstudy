package basic;

import java.util.concurrent.CountDownLatch;

/**
 * @author mhh
 * @since 2021/1/11
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread = new Thread(()->{
            System.out.println("countDownLatch 减一");
            countDownLatch.countDown();
            countDownLatch.countDown();
        });
        thread.start();
        System.out.println("countDownLatch 卡住");
        countDownLatch.await();
        System.out.println("countDownLatch 过了");
        System.out.println("countDownLatch 卡住");
        countDownLatch.await();
        System.out.println("countDownLatch 过了");

    }
}
