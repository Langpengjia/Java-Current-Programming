package phase3.chapter14;

/**
 * @classname: Singleton1
 * @description: 饿汉式
 * @author: Desire
 * @date: 2019-06-21 14:21
 */
public final class  Singleton1 {

    //私有化构造函数，不允许外部new
    private Singleton1() {
    }

    //实例变量
    private byte[] data = new byte[1024];
    // 在定义实力对象时直接初始化
    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }

}
