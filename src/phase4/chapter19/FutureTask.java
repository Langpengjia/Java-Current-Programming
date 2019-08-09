package phase4.chapter19;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @classname: FutureTask
 * @description:
 * @author: Desire
 * @date: 2019-08-09 10:14
 */
public class FutureTask<T> implements Future<T> {

    private T result;

    private boolean isDone = false;

    private final Object LOCK = new Object();


    @Override
    public T get() throws InterruptedException {
        synchronized (LOCK) {
            while (!isDone) {
                //当任务还没完成时，调用get会被挂起而进入阻塞
                LOCK.wait();
            }
            return result;
        }
    }

    @Override
    public boolean done() {
        return isDone;
    }

    protected void finish(T result) {
        synchronized (LOCK) {
            if (isDone) {
                return;
            }
            this.result = result;
            this.isDone = true;
            LOCK.notifyAll();
        }

    }
}
