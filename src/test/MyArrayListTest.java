package test;

import ClassWork.utils.MyArrayList;

/**
 * Created by gorobec on 26.05.16.
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

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
        System.out.println(list.remove(" "));

        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i));
        }
    }
}
