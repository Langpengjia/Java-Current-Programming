package phase2.chapter10;

/**
 * @classname: BootstrapClassLorder
 * @description:根加载器
 * @author: Desire
 * @date: 2019-08-06 14:02
 */
public class BootstrapClassLoader {


    public static void main(String[] args) {

        System.out.println(
                "Bootstrap:" +
                        String.class.getClassLoader()
        );

        System.out.println(System.getProperty("sun.boot.class.path"));

    }

}
