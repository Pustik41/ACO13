package ClassWork.week3.desing_patterns.decorator;

/**
 * Created by zhabenya on 26.06.16.
 */
public class Americano extends Beverage {

    @Override
    public String getDescription() {
        return "Americano";
    }

    @Override
    public double cost() {
        return 15.50;
    }
}
