package ClassWork.week1.day2.Student;

import java.util.Arrays;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class Group {

    private static final int GROUP_SIZE = 20;
    private int studentsCounter;
    private String name;
    private Student[] students;

    public Group(String name) {
        this.name = name;
        this.students = new Student[GROUP_SIZE];
    }

    public Group(String name, int groupeSize) {
        this.name = name;
        this.students = new Student[groupeSize];
    }

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public boolean addStudent(Student student){

        if(student == null) return false;

        if(studentsCounter >= students.length){
            Student[] plusSize = new Student[students.length  + 1];
            System.arraycopy(students, 0, plusSize, 0, students.length);
            students = plusSize;
        }

        students[studentsCounter] = student;
        studentsCounter++;

        return true;
    }

    public void showGroup(){

        for(int i = 0; i < studentsCounter; i++){
            System.out.println(students[i].asString());
        }

    }

    public void sortStudents(){

        String[] name = new String[studentsCounter];
        Student[] sort = new Student[studentsCounter];

        for (int i = 0; i < name.length; i++) {
            name[i] = students[i].getName();
        }

        Arrays.sort(name);

        for (int i = 0; i < name.length; i++) {

            for (int j = 0; j < name.length; j++) {

                if(name[i].equals(students[j].getName())){
                    sort[i] = students[j];
                }
            }

        }

        System.arraycopy(sort, 0, students, 0, studentsCounter);
    }

    public Student searchStudent(String name){

        for(int i = 0; i < studentsCounter; i++){

            if(name.equals(students[i].getName())){
                return students[i];
            }
        }

        return null;
    }

    public boolean delStudent(String name){

        Student[] delStudent = new Student[students.length];

        if(name.equals("") || name == null){
            System.out.println("Entered not valid value");
        } else {

            for (int i = 0; i < studentsCounter; i++) {

                if (name.equals(students[i].getName())) {
                    students[i] = null;

                    System.arraycopy(students, 0, delStudent, 0, i);
                    System.arraycopy(students, i + 1, delStudent, i, studentsCounter - i - 1);

                    studentsCounter--;

                    this.students = delStudent;

                    System.out.println("Student - " + name + " was deleted from this group");
                    return true;
                }

            }

            System.out.println(name + " - not found in this group");
        }

        return false;
    }

}
