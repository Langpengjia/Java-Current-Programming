package phase3.chapter14;

/**
 * @classname: Singleton3
 * @description: 懒汉+同步方法
 * @author: Desire
 * @date: 2019-06-21 14:52
 */
public class Singleton3 {

    private Singleton3() {
    }

    private byte[] data = new byte[1024];

    private static Singleton3 instance = null;

    public static synchronized Singleton3 getInstance(){
        if(null == instance){
            instance = new Singleton3();
        }
        return instance;
    }

}
