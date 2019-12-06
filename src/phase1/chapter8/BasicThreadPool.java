package phase1.chapter8;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class BasicThreadPool extends Thread implements  ThreadPool {

    //初始化线程池大小
    private final int initSize;
    //最大线程池大小
    private final int maxSize;
    //线程池核心线程数量
    private final int coreSize;
    //当前活跃线程数
    private int activeCount;
    //创建线程的工厂
    private ThreadFactory threadFactory;
    //任务队列
    private RunnableQueue runnableQueue;
    //判断线程池是否已经shutdown
    private volatile boolean isShutdown = false;

    //工作线程队列
    private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();

    private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscartDenyPolicy();

    private final static ThreadFactory DEFAULT_THREAD_FACROTY = new DefaultThreadFactory();

    private final long keepAliveTime;

    private final TimeUnit timeUnit;

    //构造线程池时需要传入的参数
    public BasicThreadPool(int initSize,int maxSize,int coreSize,int queueSize){
        this(initSize,maxSize,coreSize,DEFAULT_THREAD_FACROTY,queueSize,
                DEFAULT_DENY_POLICY,10,TimeUnit.SECONDS);
    }


    public BasicThreadPool(int initSize,int maxSize,int coreSize,ThreadFactory threadFactory,
                           int queueSize,DenyPolicy denyPolicy,long keepAliveTime,TimeUnit timeUnit){
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.threadFactory = threadFactory;
        this.runnableQueue = new LinkedRunnableQueue(queueSize,denyPolicy,this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();

    }

    private void init(){
        start();
        for (int i = 0; i < initSize; i++) {
            newThread();
        }
    }

    private void newThread(){
        //创建任务线程，并且启动
        InternalTask internalTask = new InternalTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(internalTask);
        ThreadTask threadTask = new ThreadTask(thread,internalTask);
        threadQueue.offer(threadTask);
        this.activeCount++;
        thread.start();
    }


    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public int getInitSize() {
        return 0;
    }

    @Override
    public int getMaxSize() {
        return 0;
    }

    @Override
    public int getCoreSize() {
        return 0;
    }

    @Override
    public int getQueueSize() {
        return 0;
    }

    @Override
    public int getActiveCount() {
        return 0;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }


    private static class ThreadTask{
        Thread thread;
        InternalTask internalTask;

        public ThreadTask(Thread thread, InternalTask internalTask) {
            this.thread = thread;
            this.internalTask = internalTask;
        }
    }

}
