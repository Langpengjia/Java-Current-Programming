package phase4.chapter15;

import java.util.concurrent.TimeUnit;

/**
 * @classname: ObservableThread
 * @description:
 * @author: Desire
 * @date: 2019-08-07 15:48
 */
public class ObservableThread<T> extends Thread implements Observable {


    private final TaskLifecycle<T> lifecycle;

    private final Task<T> task;

    private Cycle cycle;

    public ObservableThread(Task<T> task) {
        this(new TaskLifecycle.EmptyLifecycle<>(), task);
    }


    public ObservableThread(TaskLifecycle<T> lifecycle, Task<T> task) {
        super();
        if (task == null)
            throw new IllegalArgumentException("The task is required.");
        this.lifecycle = lifecycle;
        this.task = task;
    }


    @Override
    public final void run() {
        this.update(Cycle.STARTED, null, null);
        try {
            this.update(Cycle.RUNNING, null, null);
            T result = this.task.call();
            this.update(Cycle.DONE, null, null);
        } catch (Exception e) {
            this.update(Cycle.ERROR, null, e);
        }
    }

    private void update(Cycle cycle, T result, Exception e) {

        this.cycle = cycle;
        if (lifecycle == null) {
            return;
        }
        try {
            switch (cycle) {
                case STARTED:
                    this.lifecycle.onStart(currentThread());
                    break;
                case RUNNING:
                    this.lifecycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.lifecycle.onFinish(currentThread(), result);
                    break;
                case ERROR:
                    this.lifecycle.onError(currentThread(), e);
                    break;
            }
        } catch (Exception ex) {
            if (cycle == Cycle.ERROR) {
                throw ex;
            }
        }
    }


    @Override
    public Cycle getCycle() {
        return this.cycle;
    }


    public static void main(String[] args) {

        final TaskLifecycle<String> lifecycle = new TaskLifecycle.EmptyLifecycle<String>() {
            @Override
            public void onFinish(Thread thread, String result) {
                System.out.println("the result is " + result);
            }
        };


        Observable observable = new ObservableThread<>(lifecycle,() -> {
            try {
                System.out.println("I am Observing !");
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("finished done.");
            return "Hello Observer";
        });
        observable.start();
    }


}
