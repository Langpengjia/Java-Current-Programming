package phase1.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @classname: BooleanLock
 * @description:
 * @author: Desire
 * @date: 2019-07-02 13:28
 */
public class BooleanLock implements Lock {

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedLsit = new ArrayList<>();


    @Override
    public void lock() throws InterruptedException {

        synchronized (this){
            while (locked){
                blockedLsit.add(Thread.currentThread());
                this.wait();
            }
            blockedLsit.remove(Thread.currentThread());
            this.locked = true;
            this.currentThread = Thread.currentThread();
        }

    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {

    }

    @Override
    public void unlock() {

    }

    @Override
    public List<Thread> getBlockedThread() {
        return null;
    }
}
