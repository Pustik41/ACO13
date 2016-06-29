package ClassWork.week3.desing_patterns.decorator;

/**
 * Created by zhabenya on 26.06.16.
 */
public abstract class CondimentBeverage extends Beverage {

    private Beverage beverage;
    private String description;
    private double cost;


    @Override
    public abstract String getDescription();

}
