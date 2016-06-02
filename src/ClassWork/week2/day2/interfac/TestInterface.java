package ClassWork.week2.day2.interfac;

/**
 * Created by zhabenya on 29.05.16.
 */
public class TestInterface {

    public static void main(String[] args) {

        Walkable ant = new Ant();
        Swimmable fish = new Fish();
        Flyable bird = new Bird();
        Duck duck = new Duck();

        Ocean ocean = new Ocean(fish);
        Earth earth = new Earth(ant);
        Sky sky = new Sky(bird);
    }
}
