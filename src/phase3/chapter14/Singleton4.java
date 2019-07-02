package phase3.chapter14;

import java.net.Socket;
import java.sql.Connection;

/**
 * @classname: Singleton4
 * @description:
 * @author: Desire
 * @date: 2019-06-21 15:24
 */
public class Singleton4 {
    private byte[] data = new byte[1024];

    private volatile static Singleton4 instance = null;

    Connection connection;
    Socket socket;


    private Singleton4() {
        connection = null;
        socket = null;
    }

    public static Singleton4 getInstance() {
        if (null == instance) {
            synchronized (Singleton4.class) {
                if (null == instance) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

}
