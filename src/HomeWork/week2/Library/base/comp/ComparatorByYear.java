package HomeWork.week2.Library.base.comp;

import HomeWork.week2.Library.base.Prints;

import java.util.Comparator;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class ComparatorByYear implements Comparator<Prints> {
    @Override
    public int compare(Prints o1, Prints o2) {

        return o1.getYear() - o2.getYear();
    }
}
