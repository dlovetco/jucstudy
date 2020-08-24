package basic;

/**
 * 生命周期
 *
 * @author mhh
 * @see java.lang.Thread.State
 * @since 2020/8/19
 */
public class ThreadLifeCycle {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "新线程创建成功");
            //RUNNABLE
            System.out.println(Thread.currentThread().getState());
            try {
                System.out.println(Thread.currentThread().getName() + "进入睡眠");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被打断");
                //RUNNABLE
                System.out.println(Thread.currentThread().getState());
            }

            System.out.println(Thread.currentThread().getName() + "开始等待");
            synchronized (Thread.currentThread()) {
                try {
                    //WAITING
                    Thread.currentThread().wait();
                    System.out.println(Thread.currentThread().getName() + "停止等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "结束");
        });
        //NEW
        System.out.println(thread.getState());
        thread.start();
        Thread.sleep(10);
        //TIMED_WAITING
        System.out.println(thread.getState());
        thread.interrupt();
        Thread.sleep(10);

        //唤醒线程
        System.out.println(thread.getState());
        synchronized (thread) {
            thread.notify();
            System.out.println(thread.getName() + "唤醒");
        }
        //BLOCKED
        System.out.println(thread.getState());

        thread.join();
        System.out.println("等待结束");
        //TERMINATED
        System.out.println(thread.getState());
    }
}
