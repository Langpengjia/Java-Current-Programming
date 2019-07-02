package phase1.chapter4;

/**
 * @classname: DeadLock
 * @description: 一个死锁现象
 * @author: Desire
 * @date: 2019-07-01 16:59
 */
public class DeadLock {

    private final Object read = new Object();
    private final Object write = new Object();

    public void write(){
        synchronized (write){
            System.out.println(Thread.currentThread() + " GET WRITE LOCK");
            synchronized (read){
                System.out.println(Thread.currentThread() + " GET READ LOCK");
                System.out.println("I am reading a bull shit, you mother fucker!");
            }
            System.out.println(Thread.currentThread() + " RELEASE READ LOCK");
        }
        System.out.println(Thread.currentThread() + " RELEASE WRITE LOCK");
    }

    public void read(){
        synchronized (read){
            System.out.println(Thread.currentThread() + " GET READ LOCK");
            synchronized (write){
                System.out.println(Thread.currentThread() + " GET WRITE LOCK");
                System.out.println("I am writting a bull shit, you mother fucker!");
            }
            System.out.println(Thread.currentThread() + " RELEASE WRITE LOCK");
        }
        System.out.println(Thread.currentThread() + " RELEASE READ LOCK");
    }

    public static void main(String [] args){
        final DeadLock deadLock = new DeadLock();
        for (int i = 0; i < 20; i++) {
            new Thread(deadLock::read).start();
            new Thread(deadLock::write).start();
        }
    }






}
