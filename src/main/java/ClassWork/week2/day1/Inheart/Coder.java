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

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public String asString() {

        return String.format("%s, Lang - %s", super.asString(), programmingLanguage);
    }

    public void writeCode(){
        System.out.println("write code");
    }

    @Override
    public void work() {
        System.out.println("I`m making art");
    }
}
