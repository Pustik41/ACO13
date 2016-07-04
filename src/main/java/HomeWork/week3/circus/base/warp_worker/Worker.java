package HomeWork.week3.circus.base.warp_worker;

/**
 * Created by dfsdfsddfsdf on 16.06.16.
 */
public abstract class Worker {

    private String name;
    private String surName;
    private String numTel;
    private int age;
    private int salary;

    public Worker(String name, String surName, String numTel, int age, int salary) {
        this.name = name;
        this.surName = surName;
        this.numTel = numTel;
        this.age = age;
        this.salary = salary;
    }

    public void gowork(){}

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getNumTel() {
        return numTel;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s, NumTel - %s, age - %d, salary - %d", name, surName, numTel, age, salary);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(obj != null && obj instanceof Worker){
            Worker tmp = (Worker) obj;

            return this.name.equals(tmp.getName()) && this.surName.equals(tmp.getSurName()) &&
                        this.age == tmp.age && this.numTel.equals(tmp.numTel);
        }

        return false;
    }
}
