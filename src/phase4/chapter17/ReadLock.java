package phase4.chapter17;

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
