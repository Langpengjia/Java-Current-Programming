package phase1.chapter4;

import java.util.concurrent.TimeUnit;

/**
 * @classname: Mutex
 * @description: synchronized 的 monitor锁
 * @author: Desire
 * @date: 2019-07-01 16:08
 */
public class Mutex {

    private final static Object MUTEX = new Object();

    public void accessResurce() {

        synchronized (MUTEX) {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        for (int i = 0; i < 5; i++) {
            new Thread(mutex::accessResurce).start();
        }
    }

}
