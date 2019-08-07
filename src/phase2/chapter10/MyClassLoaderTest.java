package phase2.chapter10;

import java.lang.reflect.Method;

/**
 * @classname: MyClassLoaderTest
 * @description:
 * @author: Desire
 * @date: 2019-08-06 16:44
 */
public class MyClassLoaderTest {

    public static void main(String [] args) throws Exception {

        MyClassLoader classLoader = new MyClassLoader();
        Class<?> aClass = classLoader.loadClass("phase2.chapter10.HelloWorld");

        System.out.println(aClass.getClassLoader());


        Object helloworld = aClass.newInstance();

//        System.out.println(helloworld);


        Method welcome = aClass.getMethod("welcome");

        String invoke = (String)welcome.invoke(helloworld);

//        System.out.println("Result: "+invoke);

        //双亲委派
        Class<?> aClass1 = Class.forName("phase2.chapter10.HelloWorld");

        System.out.println(aClass1.getClassLoader());


    }

}
