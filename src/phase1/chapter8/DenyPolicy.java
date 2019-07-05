package phase1.chapter8;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 拒绝策略
 */
@FunctionalInterface
public interface DenyPolicy {

    void reject(Runnable runnable,ThreadPool threadPool);

    //该拒绝策略会使任务丢弃
    class DiscartDenyPolicy implements DenyPolicy{

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            //
        }
    }

    //该拒绝策略会向任务提交者抛出异常
    class AbortDebnyPolicy implements DenyPolicy{

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyException("The runnable "+ runnable +" will be abort.");
        }
    }
    //该拒绝策略会使任务在任务提交者所在的线程中执行任务
    class RunnableDenyPolicy implements DenyPolicy{

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (!threadPool.isShutdown()){
                runnable.run();
            }
        }
    }

}
