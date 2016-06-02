package ClassWork.week1.day2.Student;

import ClassWork.utils.MyDate;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class StudentTest {

    public static void main(String[] args) {

        Student st1 = new Student("Jhon", new MyDate(1991, 12, 12),'M');
        Student st2 = new Student("Fred", new MyDate(1993, 11, 7),'M');
        Student st3 = new Student("Sunny", new MyDate(1992, 10, 25),'F');
        Student st4 = new Student("Loyd", new MyDate(1991, 03, 5),'M');
        Student st5 = new Student("Bob", new MyDate(1991, 03, 5),'M');

        Group aco13 = new Group("Aco13");

        aco13.addStudent(st1);
        aco13.addStudent(st2);
        aco13.addStudent(st3);
        aco13.addStudent(st4);
       // aco13.addStudent(st5);


        aco13.showGroup();
        aco13.sortStudents();

        System.out.println("\n" + "Sort group:");


        System.out.println(aco13.contains(st5));
    }
}
