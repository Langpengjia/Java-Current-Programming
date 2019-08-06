package phase3.chapter14;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: test
 * @description:
 * @author: Desire
 * @date: 2019-06-25 10:37
 */
public class test {

    public static void main(String [] args){


        Singleton6 instance1 = Singleton6.getInstance();

        Singleton6 instance =  Singleton6.getInstance();
        System.out.println(instance1 == instance);

    }

}
