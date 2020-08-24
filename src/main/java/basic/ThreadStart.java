package basic;

/**
 * 线程的创建
 *
 * @author mhh
 * @since 2020/8/19
 */
public class ThreadStart {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName() + "新线程创建成功"));
        thread.start();
    }
}
