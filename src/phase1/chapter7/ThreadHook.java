package phase1.chapter7;

import java.util.concurrent.TimeUnit;

/**
 * @classname: ThreadHook
 * @description: hook线程
 * @author: Desire
 * @date: 2019-07-04 16:47
 */
public class ThreadHook {
    public static void main(String [] args){

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try {
                System.out.println("The hook thread 1 is running.");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The hook thread 1 is exit.");
        }));

        Runtime.getRuntime().addShutdownHook(new Thread(() ->{
            try {
                System.out.println("The hook thread 2 is running.");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The hook thread 2 is exit.");
        }));

        System.out.println("The program will is stopping.");
    }
}
