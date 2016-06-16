package HomeWork.week3.circus.base;

/**
 * Created by dfsdfsddfsdf on 16.06.16.
 */
public class Ropewalker extends Acrobat {

    private int percentageOfRisk;

    public Ropewalker(String name, String surName, String numTel, int age, int salary) {
        super(name, surName, numTel, age, salary);
        this.percentageOfRisk = (int) (Math.random() * 20);
    }

    public int getPercentageOfRisk() {
        return percentageOfRisk;
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

        String info = "Ropewalker - " + toString();
        return info;
    }
}
