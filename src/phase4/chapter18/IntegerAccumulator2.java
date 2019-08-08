package phase4.chapter18;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @classname: IntegerAccumulator2
 * @description: 尝试创造不可变对象
 * @author: Desire
 * @date: 2019-08-08 14:28
 */
public final class IntegerAccumulator2 {

    private final int init;

    public IntegerAccumulator2(IntegerAccumulator2 integerAccumulator2, int init) {
        this.init = integerAccumulator2.getValue() + init;
    }

    public IntegerAccumulator2(int init) {
        this.init = init;
    }

    public IntegerAccumulator2 add(int i) {
        return new IntegerAccumulator2(this, i);
    }

    public int getValue() {
        return this.init;
    }


    public static void main(String[] args) {

        IntegerAccumulator2 accumulator = new IntegerAccumulator2(0);
        IntStream.range(0, 3).forEach(i -> new Thread(() -> {
            int inc = 0;
            while (true) {
                int oldValue = accumulator.getValue();
                int result = accumulator.add(inc).getValue();
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
