package ClassWork.week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * Created by zhabenya on 19.06.16.
 */
public class IteratorLL {

    public static void main(String[] args) {

        List<Integer> num = new ArrayList<>();

        Collections.addAll(num, 5,4,34,23,34,5,21);

        Iterator iterator = num.iterator();

        for (Integer integer : num) {

            System.out.print(integer + " ");
        }
    }
}
