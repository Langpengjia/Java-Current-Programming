package phase1.chapter8;

/**
 * 创建线程的工厂，实现函数化（函数式接口）
 */
@FunctionalInterface
public interface ThreadFactory {

    //用于创建线程
    Thread createThread(Runnable runnable);
}
