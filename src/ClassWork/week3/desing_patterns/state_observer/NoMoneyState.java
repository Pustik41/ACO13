package ClassWork.week3.desing_patterns.state_observer;

/**
 * Created by gorobec on 05.06.16.
 */
public class NoMoneyState implements State {
    CoffeeMachine coffeeMachine ;

    public NoMoneyState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void moneyIn() {
        System.out.println("Make your choice");
        coffeeMachine.setCurrentState(coffeeMachine.getMakeChoice());
    }

    @Override
    public void makeChoice() {
        System.out.println("Put money first");
    }

    @Override
    public void makeDrink() {
        System.out.println("Put money first");
    }

    @Override
    public void cancel() {
        System.out.println("Put money first");
    }

    @Override
    public void giveMoney() {
        System.out.println("Put money first");
    }
}
