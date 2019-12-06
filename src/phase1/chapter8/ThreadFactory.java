package phase1.chapter8;

@FunctionalInterface
public interface ThreadFactory {

    //用于创建线程
    Thread createThread(Runnable runnable);
}
