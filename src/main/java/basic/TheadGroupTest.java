package basic;

/**
 * 线程组的作用应该是方便对一批线程批量操作
 * 线程组可以嵌套，A线程组下面可以有B线程组 各种操作也会递归
 *
 * @author mhh
 * @since 2020/8/20
 */
public class TheadGroupTest {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("threadGroup");
        ThreadGroup childGroup = new ThreadGroup(threadGroup, "childGroup");
        Runnable runnable = () -> {
            ThreadUtils.printThreadInfo(Thread.currentThread());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(threadGroup, runnable);
        Thread thread2 = new Thread(threadGroup, runnable);
        thread1.start();
        thread2.start();
        System.out.println(threadGroup.activeCount());
        System.out.println(threadGroup.activeGroupCount());
        threadGroup.list();
        threadGroup.interrupt();
    }
}
