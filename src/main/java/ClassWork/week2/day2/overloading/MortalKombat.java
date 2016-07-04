package ClassWork.week2.day2.overloading;

/**
 * Created by zhabenya on 29.05.16.
 */
public class MortalKombat {

    public static void main(String[] args) {
        Fighter f1 = new LukKang("Luk", 20);
        Fighter f2 = new Subzero("Sum", 10);


        Arena arena = new Arena(f1, f2);
        arena.startFight();
    }

}
