package ClassWork.week3.desing_patterns.social_network.observer;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class Gumanitaty implements ISubscribe {

    @Override
    public void notify(String massege) {
        System.out.println("mark as spam" + massege);
    }
}
