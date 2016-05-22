package week1.day2.Student;

import utils.MyDate;

/**
 * Created by zhabenya on 22.05.16.
 */
public class Student {

    private String name;

    private MyDate birthDay;

    private double averageMark;
    private char gender;

    public Student(String name, MyDate birthDay, char gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public MyDate getBirthDay() {
        return birthDay;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public char getGender() {
        return gender;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}
