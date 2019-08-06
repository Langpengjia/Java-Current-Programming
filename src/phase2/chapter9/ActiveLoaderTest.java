package phase2.chapter9;

/**
 * @classname: ActiveLoaderTest
 * @description:
 * @author: Desire
 * @date: 2019-07-30 9:58
 */
public class ActiveLoaderTest{


    public static void main(String [] args){


//        System.out.println(Child.x);
//        System.out.println("--------------------------");
//
//        /**
//         * 类只会初始化一次，上面初始化话之后，下面的调用就不会再初始化
//         */
//
//        System.out.println(Child.y);
//
//        System.out.println("--------------------------");
//        Simple[] simples = new Simple[10];

        //虽然是常量，但是需要是经过一些复杂计算结果时，会初始化
        System.out.println(Child.ram);
    }

}
