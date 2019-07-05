package phase1.chapter8;

/**
 * 任务队列，主要用于缓存提交到线程池中的任务
 */
public interface RunnableQueue {

    //当有新的任务进来时首先会offer到队列中
    void offer(Runnable runnable);

    //工作线程通过take方法获取Runnable
    Runnable take() throws InterruptedException;
    //获取任务队列中任务的数量
    int size();

}
