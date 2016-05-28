package ClassWork.week2.day1.Inheart;

/**
 * Created by zhabenya on 28.05.16.
 */
public class Coder extends Employee {

    private String programmingLanguage;

    public Coder(int age, String name, String surname, String programmingLanguage) {
        super(age, name, surname);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String asString() {

        return String.format("%s, Lang - %s", super.asString(), programmingLanguage);
    }

    @Override
    public void work() {
        System.out.println("Coder coding");
    }
}
