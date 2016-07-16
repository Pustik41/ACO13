package ClassWork.week8.date;

import java.time.*;

/**
 * Created by zhabenya on 16.07.16.
 */
public class NewData {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        LocalDate birthDay = LocalDate.MAX.of(1989, Month.DECEMBER, 13);

        Period period = Period.between(birthDay, today);

        System.out.printf("Year - %d, day - %d, days - %d\n", period.getYears(), period.getMonths(), period.getDays());

        System.out.println(today.plusDays(4));

        ZonedDateTime kievTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Kiev"));
        ZonedDateTime paris = kievTime.withZoneSameInstant(ZoneId.of("Europe/Paris"));

        System.out.println(kievTime);
        System.out.println(paris);
    }
}
