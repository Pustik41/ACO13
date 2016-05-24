package ClassWork.week1.day2.Student;

import ClassWork.utils.MyDate;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class TDD {

    public static void main(String[] args) {

        Group group = new Group("ACO");

        Student st1 = new Student("Kola", new MyDate(1991, 12, 12),'M');

        boolean expected = true;
        boolean actual = group.addStudent(st1);

        System.out.printf("Method name - %s, result - %s," + " exccepted - %s, acttual - %s\n",
                "addStudent", expected == actual, expected, actual);

        Student expected2 = st1;
        Student actual2 = group.searchStudent(st1.getName());

        System.out.printf("Method name - %s, result - %s," + " exccepted - %s, acttual - %s\n",
                "searchStudent", expected2 == actual2, expected2.asString(), actual2.asString());

        boolean expected3 = true;
        boolean actual3 = group.delStudent(st1.getName());

        System.out.printf("Method name - %s, result - %s," + " exccepted - %s, acttual - %s\n",
                "addStudent", expected3 == actual3, expected3, actual3);


    }
}
