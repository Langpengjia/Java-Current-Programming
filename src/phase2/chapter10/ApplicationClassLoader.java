package phase2.chapter10;

public class ApplicationClassLoader {

    public static void main(String [] args){

        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());

    }
}
