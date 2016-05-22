package week1.day2.Student;

import utils.MyDate;

/**
 * Created by zhabenya on 22.05.16.
 */
public class StudentTest {

    public static void main(String[] args) {

        Student st1 = new Student("Kola", new MyDate(1991, 12, 12),'M');
        Student st2 = new Student("Lok", new MyDate(1993, 11, 7),'M');

        st1.setAverageMark(4.0);

        //System.out.println(st1.asString());

        Group aco13 = new Group("Aco13");

        aco13.addStudent(st1);
        aco13.addStudent(st2);

        aco13.showGroupe();


    }
}
