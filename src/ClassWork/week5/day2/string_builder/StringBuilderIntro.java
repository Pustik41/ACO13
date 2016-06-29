package ClassWork.week5.day2.string_builder;

import ClassWork.week5.day1.time_counter.Action;
import ClassWork.week5.day1.time_counter.TimeCounter;

/**
 * Created by zhabenya on 26.06.16.
 */
public class StringBuilderIntro {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        StringBuffer sbf = new StringBuffer();

        TimeCounter sbCount = new TimeCounter();
        TimeCounter sbfCount = new TimeCounter();
        long sbTime = sbCount.count(new Action() {
            @Override
            public void run() {
                for (int i = 0; i <1000 ; i++) {
                    sb.append(i);
                }
            }
        });
        System.out.println(sbTime);

        long sbfTime = sbfCount.count(new Action() {
            @Override
            public void run() {
                for (int i = 0; i <1000 ; i++) {
                    sbf.append(i);
                }
            }
        });

        System.out.println(sbfTime);
    }
}
