package ClassWork.week3.desing_patterns.social_network.observer;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class itStudent implements ISubscribe {
    @Override
    public void notify(String massege) {
        System.out.println("I wiil read it " + massege );
    }
}
