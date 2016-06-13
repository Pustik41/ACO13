package HomeWork.week2.Library.comp;

import HomeWork.week2.Library.Prints;

import java.util.Comparator;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class ComparatorByYear implements Comparator<Prints> {
    @Override
    public int compare(Prints o1, Prints o2) {

        if(o1.getYear() - o2.getYear() < 0) return -1;
        if(o1.getYear() - o2.getYear() > 0) return 1;

        return 0;
    }
}
