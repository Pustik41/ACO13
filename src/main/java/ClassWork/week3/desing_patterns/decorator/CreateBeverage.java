package ClassWork.week3.desing_patterns.decorator;

/**
 * Created by zhabenya on 26.06.16.
 */
public class CreateBeverage {

    public static void main(String[] args) {
        Espresso espresso = new Espresso();
        System.out.println(espresso.cost());

        Milk milk = new Milk(espresso);
        System.out.println(milk.cost());
    }
}
