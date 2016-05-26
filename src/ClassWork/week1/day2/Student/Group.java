package ClassWork.week1.day2.Student;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class Group {

    private static final int DEFAULT_GROUP_SIZE = 20;
    private int studentsCounter;
    private String name;
    private Student[] students;

    public Group(String name) {
        this.name = name;
        this.students = new Student[DEFAULT_GROUP_SIZE];
    }

    public Group(String name, int groupSize) {
        this.name = name;
        this.students = new Student[groupSize];
    }

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public boolean addStudent(Student student) {

        if (student == null) return false;

        if (!contains(student.getName())) {

            if (studentsCounter >= students.length) {
//                todo make method
                Student[] plusSize = new Student[students.length + 1];
                System.arraycopy(students, 0, plusSize, 0, students.length);
                students = plusSize;
            }

            students[studentsCounter] = student;
            studentsCounter++;

            return true;
        }
        return false;
    }

    public void showGroup() {

        for (int i = 0; i < studentsCounter; i++) {
            System.out.println(students[i].asString());
        }

    }

    public void sortStudents() {

        for (int i = 0; i < studentsCounter; i++) {

            for (int j = i + 1; j < studentsCounter; j++) {

                if (students[i].getName().compareTo(students[j].getName()) > 0) {

                    Student change = students[j];
                    students[j] = students[i];
                    students[i] = change;
                }
            }

        }

    }

    public boolean contains(String name) {

//      todo check null
        for (int i = 0; i < studentsCounter; i++) {
            if (name.equals(students[i].getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean delStudent(String name) {
//        todo don't need new array (KISS)
        Student[] delStudent = new Student[students.length];

//      todo can get NullPointerException
        if (name.equals("") || name == null) {
            System.out.println("Entered not valid value");
        } else {
            for (int i = 0; i < studentsCounter; i++) {
                if (name.equals(students[i].getName())) {
                    students[i] = null;

                    System.arraycopy(students, 0, delStudent, 0, i);
                    System.arraycopy(students, i + 1, delStudent, i, studentsCounter - i - 1);

                    studentsCounter--;
                    this.students = delStudent;
                    return true;
                }
            }
        }
        return false;
    }

}
