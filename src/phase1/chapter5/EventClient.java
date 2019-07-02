package phase1.chapter5;

import java.util.concurrent.TimeUnit;

/**
 * @classname: EventClient
 * @description: 操作一个自定义队列
 * @author: Desire
 * @date: 2019-07-01 18:20
 */
public class EventClient {


    public static void main(String [] args){
        final EventQueue eventQueue = new EventQueue();
        new Thread(()->{
            for (;;) {
                eventQueue.offer(new EventQueue.Event());
            }
        },"Producer").start();
        new Thread(()->{
            for (;;) {
                eventQueue.task();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer").start();
    }



}
