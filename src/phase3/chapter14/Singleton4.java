package phase3.chapter14;

import java.net.Socket;
import java.sql.Connection;

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
