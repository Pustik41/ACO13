package ClassWork.week1.day2.Student;

import ClassWork.week1.day2.Student.Comparators.DateComparator;

import java.util.*;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class Group {

    private static final int DEFAULT_GROUP_SIZE = 20;
    private String name;
    private List<Student> students;
    private Comparator<Student> comparator = new DateComparator();

    public Group(String name) {
        this.name = name;
        this.students = new ArrayList<>(DEFAULT_GROUP_SIZE);
    }

    public Group(String name, int groupSize) {
        this.name = name;
        this.students = new ArrayList<>(groupSize);
    }

    public Group(String name, List<Student> students) {
        if(students == null) students = new ArrayList<>();
        this.name = name;
        this.students = students;
    }

    public boolean addStudent(Student student) {

        if(student != null) {

            if (!students.contains(student)) {

                students.add(student);
                return true;
            }
        }

        return false;
    }


    public void showGroup() {

        for (Student st: students) {

            System.out.println(st);
        }

    }

    public void sortStudent() {

        Collections.sort(students,comparator);
    }

    public void setComparator(Comparator<Student> comparator) {
        this.comparator = comparator;
    }

    public boolean searchStudent(Student student) {

            return students.contains(student);
    }

    public boolean delStudent(Student student) {

        return students.remove(student);
    }

}
