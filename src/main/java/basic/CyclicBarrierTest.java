package basic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author mhh
 * @since 2021/1/11
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,()->{
            System.out.println("被推倒");
            System.out.println(1/0);
        });
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("线程1执行好了 等待其他人完成");
                System.out.println("线程1 await的返回值"+cyclicBarrier.await());
                System.out.println("线程1执行完");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                System.out.println("线程1发现栅栏坏掉了");
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("线程2执行好了");
                System.out.println("线程2 await的返回值"+cyclicBarrier.await());
                System.out.println("线程2执行完");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                System.out.println("线程2发现栅栏坏掉了");
                e.printStackTrace();
            }
        }).start();
    }
}
