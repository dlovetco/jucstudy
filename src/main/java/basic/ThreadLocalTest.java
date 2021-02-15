package basic;

import java.lang.ref.WeakReference;

/**
 * @author mhh
 * @since 2021/1/11
 */
public class ThreadLocalTest {
    static ThreadLocal threadLocal = new ThreadLocal();
    public static void main(String[] args) {
        threadLocal.set(new A());
        test();
        testGc();
//        testWeakReference();
    }

   static void  test() {
        System.out.println(threadLocal.get());
    }

    static void testGc() {
        System.gc();
        System.out.println("after gc");
        System.out.println(threadLocal.get());
    }

    static void testWeakReference() {
        WeakReference weakReference = new WeakReference<>(new A());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println("after gc");
        System.out.println(weakReference.get());
    }

    static class A{

    }
}
