package phase1.chapter6;

import java.util.concurrent.TimeUnit;

/**
 * @classname: ThreadDaemon
 * @description: 守护进程
 * @author: Desire
 * @date: 2019-07-03 15:05
 */
public class ThreadDaemon {

    public static void main(String [] args) throws InterruptedException {

        ThreadGroup group1 = new ThreadGroup("Group1");
        new Thread(group1,()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"group1-thread1").start();

        ThreadGroup group2 = new ThreadGroup("Group2");
        new Thread(group2,()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"group2-thread1").start();

        group2.setDaemon(true);

        TimeUnit.SECONDS.sleep(3);

        System.out.println(group1.isDestroyed());
        System.out.println(group2.isDestroyed());
    }
}
