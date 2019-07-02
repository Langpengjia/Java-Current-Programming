package phase1.chapter4;

import java.util.HashMap;
import java.util.Map;

/**
 * @classname: HashMapDeadLock
 * @description:另外一个死锁现象,会搞死机！！！！！！ 慎重运行！！！！！！！
 * @author: Desire
 * @date: 2019-07-01 17:27
 */
public class HashMapDeadLock {

    private final Map<String, String> map = new HashMap<>();

    public void put(String key, String value) {
        this.map.put(key, value);
    }

    /**
     * 电脑配置不行请格外注意
     * 会搞死机！！！！！！ 慎重运行！！！！！！！
     *
     * @param args
     */
    public static void main(String[] args) {

        final HashMapDeadLock lock = new HashMapDeadLock();
        for (int x = 0; x < 10; x++) {
            new Thread(() -> {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    lock.put(String.valueOf(i), String.valueOf(i));
                }
            }).start();

        }

    }


}
