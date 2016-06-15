package ClassWork.week3.desing_patterns.state_observer;

/**
 * Created by gorobec on 05.06.16.
 */
public interface Observeable {

    void addObserver(MyObserver observer);
    void removeObserver(MyObserver observer);
    void notifyObservers();

}
