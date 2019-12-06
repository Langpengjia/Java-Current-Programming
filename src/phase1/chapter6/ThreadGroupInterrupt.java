package phase1.chapter6;

import java.util.concurrent.TimeUnit;

public class ThreadGroupInterrupt {

    public static void main(String [] args) throws InterruptedException {

        ThreadGroup group = new ThreadGroup("TestGroup");
        new Thread(group,() ->{
           while (true){
               try {
                   TimeUnit.MILLISECONDS.sleep(1);
               } catch (InterruptedException e) {
                   break;
               }
           }
            System.out.println("t1 will sxit.");
        },"t1").start();

        new Thread(group,()->{
            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("t3 will exit.");
        },"t3").start();

        new Thread(group,()->{
            while (true){
                try {
                    TimeUnit.MILLISECONDS.sleep(3);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("t2 will exit.");
        },"t2").start();

        TimeUnit.MILLISECONDS.sleep(2);
        group.interrupt();
    }
}
