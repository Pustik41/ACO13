package HomeWork.week2.Library.comp;

import java.util.Comparator;
import HomeWork.week2.Library.Client;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class ComparatorByNameClient implements Comparator<Client> {

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getNameClient().compareTo(o2.getNameClient());
    }
}
