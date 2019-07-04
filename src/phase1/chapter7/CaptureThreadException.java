package phase1.chapter7;

import java.util.concurrent.TimeUnit;

/**
 * @classname: CaptureThreadException
 * @description:
 * @author: Desire
 * @date: 2019-07-04 16:21
 */
public class CaptureThreadException {

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() + " occur exception");
            e.printStackTrace();
        });
        final Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1/0);
        }, "Test-Thread");
        thread.start();
    }



}
