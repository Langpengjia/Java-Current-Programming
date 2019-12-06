package phase1.chapter6;

import java.util.concurrent.TimeUnit;

public class ThreadGroupEnumerateTreads {

    public static void main(String [] args) throws InterruptedException {

        ThreadGroup myGroup = new ThreadGroup("MyGroup");

        Thread thread = new Thread(myGroup,() ->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"MyThread");
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        Thread[] list = new Thread[myGroup.activeGroupCount()];
        int recurseSize = mainGroup.enumerate(list);
        System.out.println(recurseSize);

        recurseSize = mainGroup.enumerate(list,false);
        System.out.println(recurseSize);


    }

}
