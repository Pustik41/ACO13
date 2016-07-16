package ClassWork.week8.date;

import java.util.Date;

/**
 * Created by zhabenya on 16.07.16.
 */
public class DateTest {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date.toString());
        Date date2 = new Date(1465839203l);
        System.out.println(date2.toString());

    }
}
