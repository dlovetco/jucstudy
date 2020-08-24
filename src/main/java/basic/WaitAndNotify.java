package basic;

/**
 * @author mhh
 * @since 2020/8/20
 */
public class WaitAndNotify {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread thread = new Thread(() -> {
            synchronized (o) {
                System.out.println("子线程获得锁");
                try {
                    Thread.sleep(1000);
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("子线程走出临界区");
        });
        thread.start();
        Thread.sleep(100);

        synchronized (o) {
            System.out.println("主线程获得锁");
            o.notify();
        }
        System.out.println("主线程走出临界区");
    }

}
