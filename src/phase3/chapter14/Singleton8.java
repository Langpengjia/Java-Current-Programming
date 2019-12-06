package phase3.chapter14;

public class Singleton8 {

    private byte[] data = new byte[1024];

    private Singleton8() {
    }

    private enum EnumHolder{
        INSTANCE;
        private  Singleton8 instance;

        EnumHolder(){
            this.instance = new Singleton8();
        }
        private Singleton8 getSingleton(){
            return instance;
        }
    }

    public static Singleton8 getInstance(){
        return EnumHolder.INSTANCE.getSingleton();
    }

}
