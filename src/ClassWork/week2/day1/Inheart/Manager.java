package ClassWork.week2.day1.Inheart;

/**
 * Created by zhabenya on 28.05.16.
 */
public class Manager extends  Employee {

    private Coder[] coders;
    private QA[] testers;

    public Manager(int age, String name, String surname, Coder[] coders, QA[] testers ) {
        super(age, name, surname);
        this.coders = coders;
        this.testers = testers;
    }

}
