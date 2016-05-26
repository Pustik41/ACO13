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
        list.clear();

        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i));
        }
    }
}
