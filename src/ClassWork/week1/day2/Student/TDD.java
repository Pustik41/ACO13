package ClassWork.week1.day2.Student;

import ClassWork.utils.MyDate;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class TDD {

    public static void main(String[] args) {

        Group group = new Group("ACO");

        Student st1 = new Student("Kola", new MyDate(1991, 12, 12), 'M');
        Student st2 = new Student("Serg", new MyDate(1991, 12, 12), 'M');

        addStudent(st1, group);
        addStudent(st1, group);
//todo change
       /* searchStudent(st1, group);
        searchStudent(st2, group);*/

        delStudent(st1, group);
        delStudent(st1, group);


    }



    public static void addStudent(Student st1, Group group) {
        boolean expected = true;
        boolean actual = group.addStudent(st1);

        System.out.printf("Method name - %s, result - %s," + " exccepted - %s, acttual - %s\n",
                "addStudent", expected == actual, expected, actual);
        }
//todo change

    /*public static void searchStudent(Student st1, Group group) {
            Student expected = st1;
            Student actual = group.contains(st1.getName());

            System.out.printf("Method name - %s, result - %s," + " exccepted - %s, acttual - %s\n",
                    "contains", expected == actual, expected, actual);
    }*/

    public static void delStudent(Student st1, Group group) {
        boolean expected = true;
        boolean actual = group.delStudent(st1.getName());

        System.out.printf("Method name - %s, result - %s," + " exccepted - %s, acttual - %s\n",
                "delStudent", expected == actual, expected, actual);


    }
}
