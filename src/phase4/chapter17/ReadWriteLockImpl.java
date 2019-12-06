package phase4.chapter17;

public class ReadWriteLockImpl implements ReadWriteLock {

    //定义一个对象锁
    private final Object MUTEX = new Object();

    private int writingWriters = 0;
    private int waitingWriters = 0;

    private int readingReaders = 0;

    private boolean preferWriter;

    //默认为true
    public ReadWriteLockImpl(){
        this(true);
    }

    public ReadWriteLockImpl(boolean preferWriter){
        this.preferWriter = preferWriter;
    }


    @Override
    public Lock readLock() {
        return null;
    }

    @Override
    public Lock writeLock() {
        return null;
    }

    @Override
    public int getWritingWriters() {
        return 0;
    }

    @Override
    public int getWaitingWrite() {
        return 0;
    }

    @Override
    public int getReadingReaders() {
        return 0;
    }
}
