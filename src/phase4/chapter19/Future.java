package phase4.chapter19;

public interface Future<T> {
    T get() throws InterruptedException;
    boolean done();

}
