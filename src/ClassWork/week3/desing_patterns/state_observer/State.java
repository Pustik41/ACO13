package design_patterns.state_observer;

/**
 * Created by gorobec on 05.06.16.
 */
public interface State {
    void moneyIn();
    void makeChoice();
    void makeDrink();
    void cancel();
    void giveMoney();
}
