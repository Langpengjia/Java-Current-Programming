package phase4.chapter17;

/**
 * @classname: ReadLock
 * @description:
 * @author: Desire
 * @date: 2019-08-08 12:59
 */
public class ReadLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    ReadLock(ReadWriteLockImpl readWriteLock){
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {


    }

    @Override
    public void unlock() {

    }
}
