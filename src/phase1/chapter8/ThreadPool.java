package phase1.chapter8;

/**
 * @classname: ThreadPool
 * @description: 一个简单的threadPool
 * @author: Desire
 * @date: 2019-07-04 18:13
 */
public interface ThreadPool {

    //提交任务到线程池
    void execute(Runnable runnable);

    //关闭线程池
    void shutdown();

    //获取线程池初始化大小
    int getInitSize();

    //获取线程池的最大线程数
    int getMaxSize();

    //获取线程池的核心线程数
    int getCoreSize();

    //获取线程池中用于缓存任务队列的大小
    int getQueueSize();

    //获取线程池中活跃线程的数量
    int getActiveCount();

    //查看线程池是否已经被shutdown
    boolean isShutdown();

}

