package ClassWork.week2.day2.overloading;

/**
 * Created by zhabenya on 29.05.16.
 */
public class Arena {

    private Fighter first;
    private Fighter second;

    public Arena(Fighter first, Fighter two) {
        this.first = first;
        this.second = two;
    }

    public void startFight(){

        while (first.health > 0
                && second.health > 0){

            first.hit(second);

            System.out.println(String.format("Fighter - %s hit, %s heals - %d",
                                                first.asString(), second.asString(), second.health));
            if (second.health <= 0){
                System.out.println(first.asString() + " win!");
                break;
            }
            second.hit(first);

            System.out.println(String.format("Fighter - %s hit, %s heals - %d",
                    second.asString(), first.asString(), first.health));

            if (first.health <= 0){
                System.out.println(second.asString() + " win!");
            }
        }

    }
}
