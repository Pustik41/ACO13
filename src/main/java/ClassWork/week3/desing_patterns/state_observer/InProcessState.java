package ClassWork.week3.desing_patterns.state_observer;

/**
 * Created by gorobec on 05.06.16.
 */
public class InProcessState implements State {

    CoffeeMachine coffeeMachine;

    public InProcessState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void moneyIn() {
        System.out.println("You've already put money");
    }

    @Override
    public void makeChoice() {
        System.out.println("You've already make choice");

    }

    @Override
    public void makeDrink() {
        System.out.println("Drink is already making");


    }

    @Override
    public void cancel() {
        System.out.println("Drink is already making");
    }

    @Override
    public void giveMoney() {
    }
}
