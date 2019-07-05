package phase1.chapter8;

/**
 * @classname: DefaultThreadFactory
 * @description:
 * @author: Desire
 * @date: 2019-07-05 13:34
 */
public class DefaultThreadFactory implements  ThreadFactory {
    @Override
    public Thread createThread(Runnable runnable) {
        return new Thread(() ->runnable.run());
    }
}
