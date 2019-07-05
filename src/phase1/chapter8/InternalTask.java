package phase1.chapter8;

/**
 * @classname: InternalTask
 * @description:
 * @author: Desire
 * @date: 2019-07-05 11:05
 */
public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        //如果当前线程的running为true并且没有被中断，则将不断从queue中获取
        //runnable,然后执行run
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take ();
                task.run();
            } catch (Exception e) {
                running = false;
                break;
            }
        }
    }

    public void stop() {
        this.running = false;
    }
}
