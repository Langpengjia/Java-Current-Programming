package phase1.chapter8;

public class DefaultThreadFactory implements  ThreadFactory {
    @Override
    public Thread createThread(Runnable runnable) {
        return new Thread(() ->runnable.run());
    }
}
