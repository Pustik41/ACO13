package ClassWork.week1.day2.Student.Comparators;

import ClassWork.week1.day2.Student.Student;

import java.util.Comparator;

/**
 * Created by dfsdfsddfsdf on 10.06.16.
 */
public class AverageMarkComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        return Double.compare(o1.getAverageMark(), o2.getAverageMark());
    }
}
