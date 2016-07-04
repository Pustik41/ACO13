package HomeWork.week2.Library.base.comp;

import HomeWork.week2.Library.base.Prints;

import java.util.Comparator;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class ComparatorByYear implements Comparator<Prints> {

    private static volatile Comparator<Prints> sort;

    public ComparatorByYear() {
    }

    public static Comparator<Prints> getSort(){
        if(sort == null){
            synchronized (ComparatorByTitle.class){
                sort = new ComparatorByYear();
            }
        }
        return sort;
    }

    @Override
    public int compare(Prints o1, Prints o2) {

        return o1.getYear() - o2.getYear();
    }
}
