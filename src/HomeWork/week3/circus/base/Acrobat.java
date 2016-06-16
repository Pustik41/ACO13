package HomeWork.week3.circus.base;

import HomeWork.week3.circus.base.warp_worker.Artist;

/**
 * Created by dfsdfsddfsdf on 16.06.16.
 */
public class Acrobat extends Artist {

    private int countCupsOfDrunkAlcohol;


    public Acrobat(String name, String surName, String numTel, int age, int salary) {
        super(name, surName, numTel, age, salary);

    }

    public void drinkAlcohol(){
        countCupsOfDrunkAlcohol += (int) (Math.random() * 4);
    }

    public int getCountCupsOfDrunkAlcohol() {
        return countCupsOfDrunkAlcohol;
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

        String info = "Acrobat - " + toString();
        return info;
    }
}
