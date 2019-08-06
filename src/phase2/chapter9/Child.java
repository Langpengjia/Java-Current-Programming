package phase2.chapter9;

import java.util.Random;

/**
 * @classname: Child
 * @description:
 * @author: Desire
 * @date: 2019-07-30 9:57
 */
public class Child extends Parent{

    static {
        System.out.println("The Child is initialized !");
    }

    /**
     * 此处注意区分
     * 静态常量不会触发类的初始化
     */
//    public static final int x = 10;
    public static int x = 10;


    public static final int ram = new Random().nextInt();


}