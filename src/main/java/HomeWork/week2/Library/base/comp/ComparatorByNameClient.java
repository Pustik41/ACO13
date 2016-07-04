package HomeWork.week2.Library.base.comp;

import HomeWork.week2.Library.base.Client;

import java.util.Comparator;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class ComparatorByNameClient implements Comparator<Client> {

    private static volatile Comparator<Client> sort;

    public ComparatorByNameClient() {
    }

    public static Comparator<Client> getSort(){
        if(sort == null){
            synchronized (ComparatorByTitle.class){
                sort = new ComparatorByNameClient();
            }
        }
        return sort;
    }

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getNameClient().compareTo(o2.getNameClient());
    }

}
