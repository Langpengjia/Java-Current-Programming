package phase4.chapter15;

public interface Task<T> {

    //任务执行接口，允许有返回值
    T call();
}
