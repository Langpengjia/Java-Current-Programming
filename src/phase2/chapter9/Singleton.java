package phase2.chapter9;

/**
 * @classname: Singleton
 * @description:
 * @author: Desire
 * @date: 2019-07-31 13:20
 */
public class Singleton {

    //太经典了，重点------------------
    private static Singleton singleton = new Singleton();
    private static int x = 0;
    private static int y;


    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance(){
        return singleton;
    }


    public static void main(String [] args){

        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);

    }

}
