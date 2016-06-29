package ClassWork.week5.day2.clone;

/**
 * Created by zhabenya on 26.06.16.
 */
public class Woman extends Person {

    public Child child;

    public Woman(String name, int age, Child child) {
        super(name, age);
        this.child = child;
    }

    public Woman(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Woman{" + super.toString() +
                "child=" + child +
                '}';
    }
}
