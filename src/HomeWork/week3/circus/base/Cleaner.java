package HomeWork.week3.circus.base;

import HomeWork.week3.circus.base.warp_worker.Worker;

/**
 * Created by dfsdfsddfsdf on 16.06.16.
 */
public class Cleaner extends Worker {

    public Cleaner(String name, String surName, String numTel, int age, int salary) {
        super(name, surName, numTel, age, salary);
    }


    @Override
    public void gowork() {
        System.out.println(toString() + " - cleaning");
    }

    @Override
    public String toString() {

        String info = "Cleaner - " + toString();
        return info;
    }
}
