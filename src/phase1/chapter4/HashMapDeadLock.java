package phase1.chapter4;

import java.util.HashMap;
import java.util.Map;

public class HashMapDeadLock {

    private final Map<String, String> map = new HashMap<>();

    public void put(String key, String value) {
        this.map.put(key, value);
    }

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
