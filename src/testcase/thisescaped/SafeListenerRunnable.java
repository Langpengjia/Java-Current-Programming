package testcase.thisescaped;

import java.util.List;

/**
 * @classname: SafeListenerRunnable
 * @description:
 * @author: Desire
 * @date: 2019-12-06 17:03
 */
public class SafeListenerRunnable implements Runnable{


    private EventSource<ThisSafe.EventListener> source;
    public SafeListenerRunnable(EventSource<ThisSafe.EventListener> source) {
        this.source = source;
    }
    public void run() {
        List<ThisSafe.EventListener> listeners = null;

        try {
            listeners = this.source.retrieveListeners();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(ThisSafe.EventListener listener : listeners) {
            listener.onEvent(new Object());
        }
    }
}
