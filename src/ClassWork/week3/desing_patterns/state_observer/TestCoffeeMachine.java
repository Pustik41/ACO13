package ClassWork.week3.desing_patterns.state_observer;



/**
 * Created by gorobec on 05.06.16.
 */
public class TestCoffeeMachine {
    public static void main(String[] args) {
        CoffeeCentre coffeeCentre = new CoffeeCentre();
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        CoffeeMachine coffeeMachine2 = new CoffeeMachine();

        coffeeCentre.addObserver(coffeeMachine);
        coffeeCentre.addObserver(coffeeMachine2);
        coffeeCentre.setCoffeePrice(20);
        coffeeCentre.setTeaPrice(10);

        System.out.println(coffeeMachine);
        System.out.println(coffeeMachine2);


        System.out.println(coffeeMachine);
        System.out.println(coffeeMachine2);

    }
}
