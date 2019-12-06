package phase2.chapter9;

import java.util.Random;

public class Child extends Parent{

    static {
        System.out.println("The Child is initialized !");
    }

    //    public static final int x = 10;
    public static int x = 10;


    public static final int ram = new Random().nextInt();


}