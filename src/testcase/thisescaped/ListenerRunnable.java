package testcase.thisescaped;

import java.util.List;

/**
 * @classname: ListenerRunnable this引用逸出
 * @description:
 * @author: Desire
 * @date: 2019-12-06 16:28
 */
public class ListenerRunnable implements Runnable {


    private EventSource<ThisEscape.EventListener> source;
    public ListenerRunnable(EventSource<ThisEscape.EventListener> source) {
        this.source = source;
    }
    public void run() {
        List<ThisEscape.EventListener> listeners = null;

        try {
            listeners = this.source.retrieveListeners();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(ThisEscape.EventListener listener : listeners) {
            listener.onEvent(new Object());
        }
    }

}
