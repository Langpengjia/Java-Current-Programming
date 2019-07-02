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


        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());

        }



    }

}
