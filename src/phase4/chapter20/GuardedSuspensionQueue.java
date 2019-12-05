package phase4.chapter20;

import java.util.LinkedList;

/**
 * @classname: GuardedSuspensionQueue
 * @description: 生产者消费者模式
 * @author: Desire
 * @date: 2019-10-16 16:10
 */
public class GuardedSuspensionQueue {

    public GuardedSuspensionQueue() {
    }

    private final LinkedList<Integer> queue = new LinkedList<>();

    private static final int limit = 100;


    //当queue中的数量达到limit时会陷入阻塞
    //加入对象锁
    //queue 本身不是线程安全的，但是由于被对象锁包围，所以线程安全
    //对于queue 而言 final只能保证其内存地址不会改变，无法保证内部元素的变化
    public void offer(Integer data) throws InterruptedException {

        synchronized (this){

            if (queue.size() >= limit){
                this.wait();
            }
            queue.add(data);
            this.notifyAll();
        }
    }


    //从queue中提取元素，当queue为空时会陷入阻塞
    public Integer take() throws InterruptedException {
        synchronized (this){
            if(queue.isEmpty()){
                this.wait();
            }
            this.notifyAll();
            return queue.removeFirst();

        }


    }









}
