package phase4.chapter18;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @classname: IntegerAccumulator
 * @description:
 * @author: Desire
 * @date: 2019-08-08 13:42
 */
public class IntegerAccumulator {

    private int init;

    //构造时传入初始值
    public IntegerAccumulator(int init) {
        this.init = init;
    }

    public int add(int i) {
        this.init += 1;
        return this.init;
    }


    public int getValue() {
        return this.init;
    }

    //共享资源 （accumulator） 被多个线程操作 ，导致线程不安全
//    public static void main(String[] args) {
//
//        IntegerAccumulator accumulator = new IntegerAccumulator(0);
//
//        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
//            int inc = 0;
//            while (true) {
//                //首先获得 old value
//                int oldValue = accumulator.getValue();
//                //调用add
//                int result = accumulator.add(inc);
//                System.out.println(oldValue + " + " + inc + " = " + result);
//                if(inc + oldValue != result){
//                    System.out.println("ERROR: " + oldValue + " + " + inc + " = " + result);
//                }
//                inc++;
//                //模拟延迟
//                slowly();
//            }
//        }).start());
//    }


    public static void main(String[] args) {

        IntegerAccumulator accumulator = new IntegerAccumulator(0);

        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
            int inc = 0;
            while (true) {
                int oldValue;
                int result;
                synchronized (accumulator) {
                    //首先获得 old value
                    oldValue = accumulator.getValue();
                    //调用add
                    result = accumulator.add(inc);
                }

                System.out.println(oldValue + " + " + inc + " = " + result);
                if (inc + oldValue != result) {
                    System.out.println("ERROR: " + oldValue + " + " + inc + " = " + result);
                }
                inc++;
                //模拟延迟
                slowly();
            }
        }).start());
    }

    private static void slowly() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
