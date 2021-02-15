package basic;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author mhh
 * @since 2021/1/25
 */
public class BlockingQueueTest {
    static ArrayBlockingQueue arrayBlockingQueue;

    public static void main(String[] args) {
        new Thread(() -> arrayBlockingQueue = new ArrayBlockingQueue<>(10, false, Arrays.asList(1, 2, 3))).start();

        new Thread(() -> {
            try {
                arrayBlockingQueue.put(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
