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
        System.out.println("Singleton6 is initialized !");
    }

    private static class Holder{
        private static Singleton6 instance = new Singleton6();

        private Holder() {
            System.out.println("Holder is initialized !");
        }
    }

    public static Singleton6 getInstance(){
        System.out.println("getInstance is running !");
        return Holder.instance;
    }

}
