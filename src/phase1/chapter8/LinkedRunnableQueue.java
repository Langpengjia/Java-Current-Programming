package phase1.chapter8;

import java.util.LinkedList;

/**
 * @classname: LinkedRunnableQueue
 * @description:
 * @author: Desire
 * @date: 2019-07-05 11:15
 */
public class LinkedRunnableQueue implements RunnableQueue {

    //任务队列的最大容量，构造注入
    private final int limit;
    //任务队列中的任务满时所执行的拒绝策略
    private final DenyPolicy denyPolicy;
    //存放任务的队列
    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    private ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        if (runnableList.size() >= limit) {
            //无法容纳新的线程加入时执行拒绝策略
            denyPolicy.reject(runnable, threadPool);
        } else {
            //将任务加入到队列中，并且唤醒runnableList
            runnableList.add(runnable);
            runnableList.notifyAll();
        }

    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {

                try {
                    //如果任务队列中没有可执行任务，当前线程会被挂起，进入runnableList关联的monitor waitset
                    //中等待唤醒（新的任务加入）
                    runnableList.wait();
                } catch (InterruptedException e) {
                    //被中断时将异常抛出
                    throw e;
                }
            }
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (runnableList){
            //返回队列中的任务数
            return runnableList.size();
        }
    }
}
