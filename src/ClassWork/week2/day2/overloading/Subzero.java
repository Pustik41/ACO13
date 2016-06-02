package ClassWork.week2.day2.overloading;

public class Subzero extends Fighter {

    public  int extraDamage;

    public Subzero(String name, int damage) {
        super(name, damage);
        this.extraDamage = (int) (Math.random() * 25);
    }

    @Override
    public void hit(Fighter fighter) {
       fighter.health -= damage + extraDamage;
    }
}
