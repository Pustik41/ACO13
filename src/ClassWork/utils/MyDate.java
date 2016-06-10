package ClassWork.utils;

/**
 * Created by Pustik41 on 22.05.16.
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

    public int getYearBirth(){return yearBirth;}
    public int getMonthBirth(){return monthBirth;}
    public int getBirthDay(){return birthDay;}

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        MyDate myDate = (MyDate) object;

        if (yearBirth != myDate.yearBirth) return false;
        if (monthBirth != myDate.monthBirth) return false;
        if (birthDay != myDate.birthDay) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = yearBirth;
        result = 31 * result + monthBirth;
        result = 31 * result + birthDay;
        return result;
    }

    public String asString(){
        return String.format("%d.%d.%d", birthDay, monthBirth, yearBirth);
    }
}
