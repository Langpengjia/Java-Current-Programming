package phase2.chapter9;

/**
 * @classname: Simple
 * @description:
 * @author: Desire
 * @date: 2019-07-30 9:47
 */
public class Simple {

    static {
        System.out.println("I will be initialized !");
    }

    private static final int x = 10;
    public static void test(){


    }



    public static void main(String [] args) throws ClassNotFoundException {

         Class.forName("phase2.chapter9.Simple");

    }

}
