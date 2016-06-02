package ClassWork.week1.day2.Student;

import java.util.ArrayList;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class Group {

    private static final int DEFAULT_GROUP_SIZE = 20;
    private int studentsCounter;
    private String name;
    private ArrayList<Student> students;

    public Group(String name) {
        this.name = name;
        this.students = new ArrayList<Student>(DEFAULT_GROUP_SIZE);
    }

    public Group(String name, int groupSize) {
        this.name = name;
        this.students = new ArrayList<Student>(groupSize);
    }

    public Group(String name, ArrayList<Student> students) {
        this.name = name;
        this.students = students;
    }

    public boolean addStudent(Student student) {

        if (student == null) return false;

        if (!students.contains(student)) {

            students.add(student);

            studentsCounter++;

            return true;
        }
        return false;
    }

    public void showGroup() {

        for (Student st: students) {
            System.out.println(st.toString());
        }

    }

    public void sortStudents() {

        for (int i = 0; i < studentsCounter; i++) {

            for (int j = i + 1; j < studentsCounter; j++) {

                if (students.get(i).getName().compareTo(students.get(j).getName()) > 0) {

                    Student change = students.get(j);
                    students.set(j, students.get(i));
                    students.set(i, change);
                }
            }

        }

    }

    public boolean contains(Student student) {

        if(student != null) {

            return students.contains(student);
        }
        return false;
    }

    public boolean delStudent(String name) {

        if (name == null || name.equals("")) {
            System.out.println("Entered not valid value");
        } else {
            for (int i = 0; i < studentsCounter; i++) {
                if (name.equals(students.get(i).getName())) {

                   students.remove(i);

                    studentsCounter--;
                    return true;
                }
            }
        }
        return false;
    }

}
