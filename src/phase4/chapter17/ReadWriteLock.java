package phase4.chapter17;

public interface ReadWriteLock {

    //创建 reader 锁
    Lock readLock();

    //创建 write 锁
    Lock writeLock();

    //获取当前有多少线程正在执行写操作
    int getWritingWriters();

    //获取当前有多少线程正在等待获取写入锁
    int getWaitingWrite();

    //获取当前有多少线程正在等待获取reader锁
    int getReadingReaders();

    //工厂方法，创建 ReadWriteLock
    static ReadWriteLock readWriteLock() {
        return null;
    }

    static ReadWriteLock readWriteLock(boolean preferWriter) {
        return null;
    }


}
