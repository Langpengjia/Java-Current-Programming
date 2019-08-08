package phase4.chapter15;

import java.util.Observable;
import java.util.Observer;

/**
 * @classname: TestObservable
 * @description:
 * @author: Desire
 * @date: 2019-08-08 9:33
 */
public class TestObservable extends Observable implements Observer {


    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
