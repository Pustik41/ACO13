package ClassWork.week1.day2.Student.Comparators;

import ClassWork.week1.day2.Student.Student;

import java.util.Comparator;

/**
 * Created by dfsdfsddfsdf on 10.06.16.
 */
public class DateComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        if(o1.getBirthDay().getYearBirth() - o2.getBirthDay().getYearBirth() == 0){

            if(o1.getBirthDay().getMonthBirth() - o2.getBirthDay().getMonthBirth() == 0){

                if(o1.getBirthDay().getBirthDay() - o2.getBirthDay().getBirthDay() == 0) return 0;

                return o1.getBirthDay().getBirthDay() - o2.getBirthDay().getBirthDay();
            }

            return o1.getBirthDay().getMonthBirth() - o2.getBirthDay().getMonthBirth();
        }

        return o1.getBirthDay().getYearBirth() - o2.getBirthDay().getYearBirth();
    }
}
