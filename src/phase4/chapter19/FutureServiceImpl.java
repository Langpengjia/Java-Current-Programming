package phase4.chapter19;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @classname: FutureServiceImpl
 * @description:
 * @author: Desire
 * @date: 2019-08-09 13:45
 */
public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT> {


    private final static String FUTURE_THRREAD_PREFIX = "FUTURE-";

    private final AtomicInteger nextCounter = new AtomicInteger(0);

    private String getNextName() {
        return FUTURE_THRREAD_PREFIX + nextCounter.getAndIncrement();
    }


    @Override
    public Future<?> submit(Runnable runnable) {
        final FutureTask<Void> future = new FutureTask<>();
        new Thread(() -> {
            runnable.run();
            //任务执行完成后将null作为结果传给future
            future.finish(null);
        }, getNextName()).start();
        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(() -> {
            OUT result = task.get(input);
            future.finish(result);
        }, getNextName()).start();

        return future;

    }

}
