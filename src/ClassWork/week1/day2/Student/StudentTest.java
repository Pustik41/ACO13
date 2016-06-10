package ClassWork.week1.day2.Student;

import ClassWork.utils.MyDate;
import ClassWork.week1.day2.Student.Comparators.AverageMarkComparator;
import ClassWork.week1.day2.Student.Comparators.DateComparator;
import ClassWork.week1.day2.Student.Comparators.NameComparator;
import ClassWork.week1.day2.Student.Comparators.SurnameComparator;

import java.util.ArrayList;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class StudentTest {

    public static void main(String[] args) {

        Student st1 = new Student("Jhon", "Falcone", new MyDate(1991, 12, 12),'M');
        Student st2 = new Student("Fred", "Rodnie", new MyDate(1993, 11, 7),'M');
        Student st3 = new Student("Sunny", "Jakore", new MyDate(1992, 10, 25),'F');
        Student st4 = new Student("Loyd", "Bubble", new MyDate(1991, 03, 10),'M');
        Student st5 = new Student("Bob", "Loris", new MyDate(1991, 03, 5),'M');

        Group aco13 = new Group("Aco13");

        aco13.addStudent(st1);
        aco13.addStudent(st2);
        aco13.addStudent(st3);
        aco13.addStudent(st4);
        aco13.addStudent(st5);

        st1.setAverageMark(9.8);
        st2.setAverageMark(9.0);
        st3.setAverageMark(9.3);
        st4.setAverageMark(9.8);
        st5.setAverageMark(9.2);


        aco13.showGroup();

        //aco13.sortStudents(new DateComparator());
        //aco13.sortStudents(new NameComparator());
        //aco13.sortStudents(new SurnameComparator());
        aco13.sortStudent();

        System.out.println("\n" + "Sort group:");
        aco13.showGroup();
    }
}
