package basic;

import java.util.concurrent.CountDownLatch;

/**
 * @author mhh
 * @since 2021/1/11
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("countDownLatch 减一");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
    }
}
