package phase2.chapter9;

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
