package ClassWork.week1.day2.Student.Comparators;

import ClassWork.week1.day2.Student.Student;

import java.util.Comparator;

/**
 * Created by dfsdfsddfsdf on 10.06.16.
 */
public class SurnameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        return o1.getSurName().compareTo(o2.getSurName());
    }
}
