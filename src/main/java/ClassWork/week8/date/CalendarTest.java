package ClassWork.week8.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by zhabenya on 16.07.16.
 */
public class CalendarTest {

    public static void main(String[] args) {
        Calendar gc =  new GregorianCalendar(2020, 5, 24);
        System.out.println(gc.getTime());

        DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.G 'at' HH:mm:ss" );

        System.out.println(sdf.format(new Date()));
    }
}
