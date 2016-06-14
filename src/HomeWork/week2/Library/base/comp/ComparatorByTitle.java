package HomeWork.week2.Library.base.comp;

import HomeWork.week2.Library.base.Prints;

import java.util.Comparator;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class ComparatorByTitle implements Comparator<Prints> {

    @Override
    public int compare(Prints o1, Prints o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
