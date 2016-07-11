package ClassWork.week1.day2.Student;

import data_structures.MyDate;

import java.io.Serializable;

/**
 * Created by Pustik41 on 22.05.16.
 */
public class Student implements Comparable, Serializable {

    private String name;
    private String surName;
    private MyDate birthDay;
    private double averageMark;
    private char gender;

    public Student(String name, String surName, MyDate birthDay, char gender) {
        this.name = name;
        this.surName = surName;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;

        if(!(o instanceof Student)) return false;

        Student tmp = (Student) o;

        return this.name.equals(tmp.name) && this.birthDay.equals(tmp.birthDay);
    }

    @Override
    public String toString(){
        return String.format("%s, %s, BD - %s, averageMark - %.1f", name, surName, birthDay.toString(), averageMark);
    }

    @Override
    public int compareTo(Object o) {
        if(this == o) return 0;
        if(o != null && o instanceof Student){
            Student tmp = (Student) o;

            return this.name.compareTo(tmp.name);
        }

        return -1;
    }


}
