package phase1.chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

/**
 * @classname: BooleanLock
 * @description:
 * @author: Desire
 * @date: 2019-07-02 13:28
 */
public class BooleanLock implements Lock {

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();


    @Override
    public void lock() throws InterruptedException {

        synchronized (this) {
            while (locked) {
                //此处与原书有歧义，原书无法通过编译 currentThread()
                blockedList.add(currentThread());
                this.wait();
            }
            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }

    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {

        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainingMills = mills;
                //此处与原书不符
                long endMills = currentTimeMillis() + remainingMills;
                while (locked) {
                    if (remainingMills <= 0) {
                        throw new TimeoutException("can not get the lock during " + mills);
                    }
                    if (!blockedList.contains(currentThread())) {
                        blockedList.add(currentThread());
                    }
                    this.wait(remainingMills);
                    remainingMills = endMills - currentTimeMillis();
                }
            }
        }
    }

    @Override
    public void unlock() {

        synchronized (this) {
            if (currentThread == currentThread()) {
                this.locked = false;
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThread() {
        //不可变list符合面向对象编程思想
        return Collections.unmodifiableList(blockedList);
    }
}
