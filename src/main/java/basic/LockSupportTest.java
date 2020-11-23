package basic;

public class LockSupportTest {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println(Thread.interrupted());
            System.out.println(Thread.currentThread().isInterrupted());
        });
        thread.start();
//        thread.interrupt();
    }
}
