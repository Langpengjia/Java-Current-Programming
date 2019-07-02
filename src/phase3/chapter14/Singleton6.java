package phase3.chapter14;

/**
 * @classname: Singleton5
 * @description: Holder模式
 * @author: Desire
 * @date: 2019-06-24 15:17
 */
public class Singleton6 {

    private byte[] data = new byte[1024];

    private Singleton6() {
    }

    private static class Holder{
        private static Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return Holder.instance;
    }

}
