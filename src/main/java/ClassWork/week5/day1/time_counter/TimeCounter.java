package ClassWork.week5.day1.time_counter;

import java.io.IOException;

/**
 * Created by zhabenya on 25.06.16.
 */
public class TimeCounter {

    public long count(Action action){

        long start = System.currentTimeMillis();
        try {
            action.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long finish = System.currentTimeMillis();

        return finish - start;
    }
}
