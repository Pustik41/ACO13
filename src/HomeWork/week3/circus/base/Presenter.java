package HomeWork.week3.circus.base;

import HomeWork.week3.circus.base.warp_worker.Artist;

/**
 * Created by dfsdfsddfsdf on 16.06.16.
 */
public class Presenter extends Artist {

    public Presenter(String name, String surName, String numTel, int age, int salary) {
        super(name, surName, numTel, age, salary);
    }

    @Override
    public void rehearse() {

        System.out.println(this.toString() + " - rehearse");
    }

    @Override
    public void gowork() {
        System.out.println(toString() + " - perform");
    }

    @Override
    public String toString() {

        String info = "Presenter - " + toString();
        return info;
    }
}
