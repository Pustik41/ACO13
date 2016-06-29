package ClassWork.week3.desing_patterns.decorator;

/**
 * Created by zhabenya on 26.06.16.
 */
public abstract class Beverage {
    protected String description;

    public String getDescription(){
        return description;
    }

    public abstract double cost();

}
