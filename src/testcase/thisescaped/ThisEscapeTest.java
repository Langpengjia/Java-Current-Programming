package testcase.thisescaped;

/**
 * @classname: ThisEscapeTest
 * @description:
 * @author: Desire
 * @date: 2019-12-06 16:35
 */
public class ThisEscapeTest {

    public static void main(String[] args) {
        //会造成错误结果的方式
        EventSource<ThisEscape.EventListener> source = new EventSource<>();
        ListenerRunnable listRun = new ListenerRunnable(source);
        Thread thread = new Thread(listRun);
        thread.start();
        ThisEscape escape = new ThisEscape(source);




        //正确的方式
        EventSource<ThisSafe.EventListener> source1 = new EventSource<>();
        SafeListenerRunnable listRun1 = new SafeListenerRunnable(source1);
        Thread thread1 = new Thread(listRun1);
        thread1.start();
        ThisSafe escape1 = ThisSafe.getInstance(source1);

    }

}
