package ClassWork.week2.day2.interfac;

/**
 * Created by zhabenya on 29.05.16.
 */
public class Duck implements Walkable, Flyable, Swimmable {
    @Override
    public void walk() {
        System.out.println("Duck");
    }

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}
