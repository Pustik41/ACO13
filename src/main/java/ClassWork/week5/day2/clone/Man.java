package ClassWork.week5.day2.clone;

/**
 * Created by zhabenya on 26.06.16.
 */
public class Man extends Person {

    public Woman wife;

    public Man(String name, int age, Woman wife) {
        super(name, age);
        this.wife = wife;
    }

    public Man(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Man{" + super.toString() +
                "wife=" + wife +
                '}';
    }

    @Override
    public Man clone() throws CloneNotSupportedException {
        return (Man) super.clone();
    }
}
