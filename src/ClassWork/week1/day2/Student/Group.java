package ClassWork.week1.day2.Student;

import ClassWork.week1.day2.Student.Comparators.AverageMarkComparator;
import ClassWork.week1.day2.Student.Comparators.DateComparator;
import ClassWork.week1.day2.Student.Comparators.NameComparator;
import ClassWork.week1.day2.Student.Comparators.SurnameComparator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class Group {

    private static final int DEFAULT_GROUP_SIZE = 20;
    private String name;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
        this.students = new ArrayList<Student>(DEFAULT_GROUP_SIZE);
    }

    public Group(String name, int groupSize) {
        this.name = name;
        this.students = new ArrayList<Student>(groupSize);
    }

    public Group(String name, List<Student> students) {
        if(students == null) students = new ArrayList<Student>();
        this.name = name;
        this.students = students;
    }

    public boolean addStudent(Student student) {

        if (student == null) return false;

        if (!searchStudent(student)) {

            students.add(student);

            return true;
        }
        return false;
    }


    public void showGroup() {

        for (Student st: students) {
            System.out.println(st.toString());
        }

    }

    public void sortStudents(Comparator comparator) {

        if(comparator instanceof NameComparator){
            students.sort(new NameComparator());
            return;
        }

        if(comparator instanceof SurnameComparator){
            students.sort(new SurnameComparator());
            return;
        }

        if(comparator instanceof DateComparator){
            students.sort(new DateComparator());
            return;
        }

        if(comparator instanceof AverageMarkComparator){
            students.sort(new AverageMarkComparator());
            return;
        }

        System.out.println("Not valid Comparator");
    }

    public boolean searchStudent(Student student) {

        if(student != null) {

            return students.contains(student);
        }

        return false;
    }

    public boolean delStudent(Student student) {

        return students.remove(student);
    }

}
