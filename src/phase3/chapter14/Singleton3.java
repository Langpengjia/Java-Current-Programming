package phase3.chapter14;

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
