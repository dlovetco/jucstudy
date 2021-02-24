package basic;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author mhh
 * @since 2021/2/24
 */
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.add(1);
        concurrentLinkedQueue.add(2);
        concurrentLinkedQueue.add(3);
        System.out.println(concurrentLinkedQueue.poll());
        System.out.println(concurrentLinkedQueue.poll());

    }
}
