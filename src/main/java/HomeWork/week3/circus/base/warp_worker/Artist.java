package HomeWork.week3.circus.base.warp_worker;

/**
 * Created by dfsdfsddfsdf on 16.06.16.
 */
public abstract class Artist extends Worker {

    private int countProtrude;

    public Artist(String name, String surName, String numTel, int age, int salary) {
        super(name, surName, numTel, age, salary);
    }

    public void rehearse(){}

    public int getCountProtrude() {
        return countProtrude;
    }

    public void setCountProtrude(int countProtrude) {
        this.countProtrude += countProtrude;
    }
}
