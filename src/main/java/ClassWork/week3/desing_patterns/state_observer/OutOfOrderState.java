package ClassWork.week3.desing_patterns.state_observer;

/**
 * Created by gorobec on 05.06.16.
 */
public class OutOfOrderState implements State {
    CoffeeMachine coffeeMachine;

    public OutOfOrderState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void moneyIn() {
        System.out.println("Sorry out of order");
    }

    @Override
    public void makeChoice() {
        System.out.println("Sorry out of order");

    }

    @Override
    public void makeDrink() {
        System.out.println("Sorry out of order");

    }

    @Override
    public void cancel() {
        System.out.println("Sorry out of order");

    }

    @Override
    public void giveMoney() {
        System.out.println("Sorry out of order");
    }
}
