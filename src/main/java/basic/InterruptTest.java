package basic;

public class InterruptTest {
    volatile static boolean b = true;
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (b) {

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.interrupt();
        Thread.sleep(10);
        b = false;

    }
}
