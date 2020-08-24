package basic;

/**
 * @author mhh
 * @since 2020/8/19
 */
public class ThreadUtils {

    public static void printThreadInfo(Thread thread) {
        System.out.println("id=" + thread.getId());
        System.out.println("name=" + thread.getName());
        System.out.println("priority=" + thread.getPriority());
        System.out.println("state=" + thread.getState());
    }
}
