package basic;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

/**
 * @author mhh
 * @since 2020/8/20
 */
public class OtherTest {


    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException, IOException {
        SynchronousQueue synchronousQueue = new SynchronousQueue<Runnable>(true);
        synchronousQueue.put(1);
        synchronousQueue.put(2);
    }

}
