package ClassWork.week2.day1.Inheart;

/**
 * Created by zhabenya on 28.05.16.
 */
public class Employee {

    private int age;
    private String name;
    private String surname;

    public Employee() {
    }

    public Employee(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public String asString(){
        return String.format("Name - %s, Surname - %s, Age - %d", name, surname, age);
    }

    public void work(){
        System.out.println("Working Employee");
    }
}
