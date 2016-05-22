package utils;

/**
 * Created by zhabenya on 22.05.16.
 */
public class MyDate {

    private int yearBirth;
    private int monthBirth;
    private int birthDay;


    public MyDate(int year, int month, int birthDay) {
        this.yearBirth = year;
        this.monthBirth = month;
        this.birthDay = birthDay;
    }

    public String asString(){
        return String.format("%d.%d.%d", birthDay, monthBirth, yearBirth);
    }
}
