package ClassWork.week3.desing_patterns.state_observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gorobec on 05.06.16.
 */
public class CoffeeCentre implements Observeable{

    private List<MyObserver>  observers;
    private int teaPrice;

    public int getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(int coffeePrice) {
        this.coffeePrice = coffeePrice;
        notifyObservers();
    }

    public int getTeaPrice() {
        return teaPrice;
    }

    public void setTeaPrice(int teaPrice) {
        this.teaPrice = teaPrice;
        notifyObservers();
    }

    private  int coffeePrice;


    public CoffeeCentre() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MyObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (MyObserver observer : observers) {
            observer.update(coffeePrice, teaPrice);
        }

    }
}
