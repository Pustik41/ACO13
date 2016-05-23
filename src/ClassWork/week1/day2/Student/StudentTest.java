package ClassWork.week1.day2.Student;

import ClassWork.utils.MyDate;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class StudentTest {

    public static void main(String[] args) {



        Student st1 = new Student("Kolja", new MyDate(1991, 12, 12),'M');
        Student st2 = new Student("Vasja", new MyDate(1993, 11, 7),'M');
        Student st3 = new Student("Sveta", new MyDate(1992, 10, 25),'F');
        Student st4 = new Student("Serega", new MyDate(1991, 03, 5),'M');
        Student st5 = new Student("Igor", new MyDate(1991, 03, 5),'M');

        st1.setAverageMark(4.0);

        //System.out.println(st1.asString());

        Group aco13 = new Group("Aco13");

        aco13.addStudent(st1);
        aco13.addStudent(st2);
        aco13.addStudent(st3);
        aco13.addStudent(st4);
        aco13.addStudent(st5);





        String searchName = "Pro";

        //System.out.println("Information about searching name - " + searchName + ": \n" + aco13.searchStudent(searchName).asString());

        System.out.println();

        aco13.showGroupe();
        aco13.sortStudents();
        System.out.println();
        aco13.showGroupe();
        /*aco13.delStudent("Katja");
        aco13.sortStudents();

        System.out.println();


        //aco13.showGroupe();*/

    }
}
