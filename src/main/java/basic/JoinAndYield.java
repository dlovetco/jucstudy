package basic;

/**
 * @author mhh
 * @since 2020/8/19
 */
public class JoinAndYield {

    public static void main(String[] args) throws InterruptedException {
        testNotify();
    }

    /**
     * yield表示自己让出线程 但是自己还是会去抢占
     * join表示当前线程等待其他线程结束
     *
     * @throws InterruptedException
     */
    private static void testYield() throws InterruptedException {
        Runnable runnable = () -> {
            synchronized (Thread.currentThread()) {
                Thread.currentThread().notifyAll();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
                Thread.yield();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程" + Thread.currentThread().getName() + "结束");
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("主线程结束");
    }

    private static void testNotify() throws InterruptedException {
        //被唤醒线程
        Thread thread1 = new Thread(() -> {
            try {
                synchronized (Thread.currentThread()) {
                    System.out.println("线程1开始wait");
                    Thread.currentThread().wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread thread2 = new Thread(new MyRunnable(thread1));
        thread1.start();
        Thread.sleep(10);
        thread2.start();
        synchronized (thread1) {
            System.out.println("主线程中 唤醒线程1");
            thread1.notify();
        }
        System.out.println("主线程开始join 线程1");
        thread1.join();
        System.out.println("主线程结束");
    }

    private static class MyRunnable implements Runnable {

        private Thread otherThread;

        public MyRunnable(Thread otherThread) {
            this.otherThread = otherThread;
        }

        @Override
        public void run() {
            synchronized (otherThread) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("唤醒线程1");
//                otherThread.notifyAll();

            }
        }
    }

}
