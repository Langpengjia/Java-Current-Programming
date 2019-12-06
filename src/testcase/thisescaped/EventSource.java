package testcase.thisescaped;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: EventSource
 * @description:
 * @author: Desire
 * @date: 2019-12-06 16:10
 */
public class EventSource<T> {


    private final List<T> eventListeners;

    public EventSource() {
        eventListeners = new ArrayList<T>();
    }

    public synchronized void registerListener(T eventListener) {
        this.eventListeners.add(eventListener);
        this.notifyAll();
    }

    public synchronized List<T> retrieveListeners() throws InterruptedException {
        List<T> dest = null;
        if (eventListeners.size() <= 0) {
            this.wait();
        }
        dest = new ArrayList<T>(eventListeners.size());
        dest.addAll(eventListeners);
        return dest;
    }

}
