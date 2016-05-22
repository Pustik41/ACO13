package week1.day2.Student;

import utils.MyDate;

/**
 * Created by zhabenya on 22.05.16.
 */
public class TDD {

    public static void main(String[] args) {

        Group group = new Group("ACO");

        Student st1 = new Student("Kola", new MyDate(1991, 12, 12),'M');

        boolean expected = true;
        boolean actual = group.addStudent(st1);

        System.out.printf("Method name - %s, result - %s," + " exccepted - %s, acttual - %s\n", "addStudent", expected == actual, expected, actual);
    }
}
