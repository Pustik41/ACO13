package HomeWork.week3.circus.base;

import HomeWork.week3.circus.base.warp_worker.Worker;

/**
 * Created by dfsdfsddfsdf on 16.06.16.
 */
public class StageWorker extends Worker {


    public StageWorker(String name, String surName, String numTel, int age, int salary) {
        super(name, surName, numTel, age, salary);
    }

    @Override
    public void gowork() {
        System.out.println(toString() + " - stage preparation");
    }

    @Override
    public String toString() {

        String info = "StageWorker - " + toString();
        return info;
    }
}
