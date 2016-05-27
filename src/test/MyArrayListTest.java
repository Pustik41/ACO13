package test;

import ClassWork.utils.MyArrayList;

import java.util.ArrayList;

/**
 * Created by gorobec on 26.05.16.
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        /*MyArrayList<String> list = new MyArrayList<>();

        list.add("Hello");
        list.add(" ");
        list.add("world!");
        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i));
        }

        String name = list.set(0, "Katja");
        System.out.println("\n" + name);

        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i));
        }

        System.out.println("\n" + list.remove(0));
        //System.out.println(list.remove(" "));

        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i));

        }

        System.out.println();*/

        MyArrayList<Integer> numList = new MyArrayList<Integer>();

        for (int i = 0; i <10 ; i++) {

            numList.add(i * 2);
            System.out.print(numList.get(i) + " ");
        }

        Integer num = null;

        numList.remove(3);
        numList.remove(num);

        System.out.println();

        for (int i = 0; i < numList.size() ; i++) {

            System.out.print(numList.get(i) + " ");
        }
    }
}
