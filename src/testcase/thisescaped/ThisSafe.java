package testcase.thisescaped;

/**
 * @classname: ThisSafe 安全构建的类
 * @description:
 * @author: Desire
 * @date: 2019-12-06 16:59
 */
public class ThisSafe {


    public final int id;
    public final String name;
    private final EventListener listener;

    private ThisSafe() {
        id = 2;
        listener = new EventListener() {
            public void onEvent(Object obj) {
                System.out.println("id: " + ThisSafe.this.id);
                System.out.println("name: " + ThisSafe.this.name);
            }
        };
        name = "this is the right thing";
    }

    public static ThisSafe getInstance(EventSource<EventListener> source) {
        ThisSafe safe = new ThisSafe();
        source.registerListener(safe.listener);
        return safe;
    }


    class EventListener {

        public void onEvent(Object o) {

        }

    }
}
