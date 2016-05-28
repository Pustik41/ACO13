package ClassWork.week2.day1.Inheart;

/**
 * Created by zhabenya on 28.05.16.
 */
public class QA extends Employee {

    private int extraMoney;


    public QA(int age, String name, String surname, int extraMoney) {
        super(age, name, surname);
        this.extraMoney = extraMoney;
    }

    @Override
    public String asString() {
        return String.format("%s, bonus - %s", super.asString(), extraMoney );
    }

    @Override
    public void work() {
        System.out.println("QA testing");
    }
}
