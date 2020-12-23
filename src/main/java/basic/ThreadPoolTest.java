package basic;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mhh
 * @since 2020/12/17
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.MINUTES, new LinkedBlockingDeque<>(50));
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("第一波结束了" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.setCorePoolSize(1);
        threadPoolExecutor.setMaximumPoolSize(1);
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    System.out.println("第二波开始了" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
