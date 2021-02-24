package basic;

import java.util.concurrent.SynchronousQueue;

/**
 * @author mhh
 * @since 2021/2/23
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue synchronousQueue = new SynchronousQueue<Runnable>();
        new Thread(()->{
            try {
                synchronousQueue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1结束");
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object poll = synchronousQueue.poll();
            System.out.println(poll.toString());
        }).start();
    }
}
