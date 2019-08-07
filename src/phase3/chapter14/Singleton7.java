package phase3.chapter14;

/**
 * @classname: Singleton7
 * @description:   枚举
 * @author: Desire
 * @date: 2019-08-07 14:39
 */
public enum Singleton7 {

    INSTANCE;

    private byte[] data = new byte[1024];


    Singleton7(){
        System.out.println("INSTANCE will be initialized immediately!");
    }

    public void mehtod(){


    }


    public static  Singleton7 getInstance(){
        return INSTANCE;
    }





}
