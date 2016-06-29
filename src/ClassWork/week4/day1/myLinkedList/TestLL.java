package ClassWork.week4.day1.myLinkedList;

import ClassWork.week4.day1.myLinkedList.MyLinkedList;

import java.util.List;

/**
 * Created by zhabenya on 18.06.16.
 */
public class TestLL {

    public static void main(String[] args) {

        List list = new MyLinkedList();

        list.add(5);
        list.add(15);
        list.add(25);

        int expected = 3;
        int actual = list.size();
        boolean result = actual == expected;
        System.out.printf("Method add, result - %s, expected - %s, actual - %s\n ", result, expected, actual);

        expected = 2;
        actual = list.indexOf(25);
        result = actual == expected;
        System.out.printf("Method add, result - %s, expected - %s, actual - %s\n ", result, expected, actual);


       /* expected = 5;
        actual = (Integer) list.remove(0);
        result = actual == expected;
        System.out.printf("Method remove, result - %s, expected - %s, actual - %s\n ", result, expected, actual);

        expected = 25;
        actual = (Integer) list.remove(1);
        result = actual == expected;
        System.out.printf("Method remove, result - %s, expected - %s, actual - %s\n ", result, expected, actual);

        expected = 15;
        actual = (Integer) list.remove(0);
        result = actual == expected;
        System.out.printf("Method remove, result - %s, expected - %s, actual - %s\n ", result, expected, actual);*/

    }
}
