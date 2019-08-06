package phase2.chapter10;

/**
 * @classname: ApplicationClassLoader
 * @description:
 * @author: Desire
 * @date: 2019-08-06 14:56
 */
public class ApplicationClassLoader {

    public static void main(String [] args){

        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());

    }
}
