package phase1.chapter5;

import java.util.concurrent.TimeUnit;

/**
 * @classname: SychronizeDefeat
 * @description:
 * @author: Desire
 * @date: 2019-07-02 10:30
 */
public class SychronizeDefeat {

    public synchronized void syncMethod() {
        try {
            TimeUnit.HOURS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {

//        SychronizeDefeat defeat = new SychronizeDefeat();
//
//        new Thread(defeat::syncMethod,"T1").start();
//
//        TimeUnit.MILLISECONDS.sleep(20);
//
//        Thread t2 = new Thread(defeat::syncMethod, "T2");
//
//        TimeUnit.MILLISECONDS.sleep(20);
//
//        t2.interrupt();
//
//        System.out.println(t2.isInterrupted());
//        System.out.println(t2.getState());


        Thread t1 = new Thread(() -> {
            System.out.println("I am running !");
        });

        for (int i = 0; i < 15; i++) {
            System.out.println(i);
            System.out.println(t1.getState());
            if(t1.isInterrupted()){
                System.out.println("Oh! I will stop !");
                System.out.println(t1.getState());
            }
            if (i == 1) {
                t1.start();

            }
            t1.wait();
            if(t1.getState() == Thread.State.WAITING){
                System.out.println("Oh! I am blocked !");
                System.out.println(t1.getState());
            }
            TimeUnit.SECONDS.sleep(1);
            if (i == 5) {
                t1.interrupt();
            }

        }

    }


}
