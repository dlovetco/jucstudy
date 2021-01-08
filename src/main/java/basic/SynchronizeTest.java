package basic;

/**
 * @author mhh
 * @since 2021/1/7
 */
public class SynchronizeTest {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Thread.currentThread().interrupt();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        thread.interrupt();
        thread.start();
    }
}
