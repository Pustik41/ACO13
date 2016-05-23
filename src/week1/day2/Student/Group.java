package week1.day2.Student;

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
        if(studentsCounter >= students.length - 1) return false;

        // todo check if present in group

        students[studentsCounter] = student;
        studentsCounter++;

        return true;
    }

    public void showGroupe(){
        /*for(Student st: students){
            System.out.print(st.asString());
        }*/

        for(int i = 0; i < studentsCounter; i++){
            System.out.println(students[i].asString());
        }

    }

    public Student sortStudents(Student[] students){
        return null;
    }

    public Student search(String name){
        return null;
    }

    public boolean delStudent(Student student){
        return false;
    }
}
