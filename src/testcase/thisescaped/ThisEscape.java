package testcase.thisescaped;


import java.util.concurrent.TimeUnit;

/**
 * @classname: ThisEscape
 * @description:
 * @author: Desire
 * @date: 2019-12-06 16:09
 */
public class ThisEscape {

    private int id;
    private String name;


    public ThisEscape(EventSource<EventListener> source) {


        id = 1;
        source.registerListener(new EventListener() {
            public void onEvent(Object o) {
                System.out.println("id: " + ThisEscape.this.id);
                System.out.println("name: " + ThisEscape.this.name);
            }
        });
        //延长构造时间以制造逸出
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "flysqrlboy";
    }


    class EventListener{

        public void onEvent (Object o){

    }

    }
}
