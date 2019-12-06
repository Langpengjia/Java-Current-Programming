package phase1.chapter4;

import java.util.concurrent.TimeUnit;

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
