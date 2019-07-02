package phase3.chapter14;

/**
 * @classname: Singleton2
 * @description: 懒汉式
 * @author: Desire
 * @date: 2019-06-21 14:26
 */
public class Singleton2 {

    private Singleton2() {
    }

    private byte[] data = new byte[1024];

    private static Singleton2 instance = null;

    public static Singleton2 getInstance(){
        if(null == instance){
            instance = new Singleton2();
        }
        return instance;
    }

}
