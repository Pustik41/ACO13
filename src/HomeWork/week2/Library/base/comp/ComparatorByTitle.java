package HomeWork.week2.Library.base.comp;

import HomeWork.week2.Library.base.Prints;

import java.util.Comparator;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class ComparatorByTitle implements Comparator<Prints> {
    private static volatile Comparator<Prints> instance;

    private ComparatorByTitle() {
    }

    public static Comparator<Prints> getInstance(){
        if(instance == null){
            synchronized (ComparatorByTitle.class){
                instance = new ComparatorByTitle();
            }
        }
        return instance;
    }

    private static volatile Comparator<Prints> sort;

    private ComparatorByTitle() {
    }

    public static Comparator<Prints> getSort(){
        if(sort == null){
            synchronized (ComparatorByTitle.class){
                sort = new ComparatorByTitle();
            }
        }
        return sort;
    }

    @Override
    public int compare(Prints o1, Prints o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
