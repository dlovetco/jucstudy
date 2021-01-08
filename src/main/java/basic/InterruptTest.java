package basic;

public class InterruptTest {
    volatile static boolean b = true;
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            System.out.println(Thread.currentThread().isInterrupted());
            Thread.interrupted();
            System.out.println(Thread.currentThread().isInterrupted());
            Thread.interrupted();
            System.out.println(Thread.currentThread().isInterrupted());
        });
        thread.start();
        thread.interrupt();
        b = false;

    }
}
