package phase2.chapter11;

/**
 * @classname: MainThreadClassLoader
 * @description:
 * @author: Desire
 * @date: 2019-08-07 10:05
 */
public class MainThreadClassLoader {


    public static void main(String [] args){


        System.out.println(Thread.currentThread().getContextClassLoader());

    }

}
