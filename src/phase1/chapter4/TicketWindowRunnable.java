package phase1.chapter4;

/**
 * @classname: TicketWindowRunnable
 * @description: 第一章银行领号的线程安全实现
 * @author: Desire
 * @date: 2019-07-01 15:56
 */
public class TicketWindowRunnable implements Runnable{

    private int index = 1;
    private final static int Max = 500;

    //为实现线程安全
    private final Object o = new Object();

    @Override
    public void run() {
        synchronized (o){
            while (index <= Max){
                System.out.println(Thread.currentThread() + "的号码是" + (index++));
            }
        }
    }


    public static void main(String [] args){

        final TicketWindowRunnable task = new TicketWindowRunnable();
        Thread thread1 = new Thread(task, "一号窗口");
        Thread thread2 = new Thread(task, "二号窗口");
        Thread thread3 = new Thread(task, "三号窗口");
        Thread thread4 = new Thread(task, "四号窗口");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
