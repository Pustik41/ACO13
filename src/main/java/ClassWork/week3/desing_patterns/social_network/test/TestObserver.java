package ClassWork.week3.desing_patterns.social_network.test;

import ClassWork.week3.desing_patterns.social_network.EducationSystemController;
import ClassWork.week3.desing_patterns.social_network.observer.Gumanitaty;
import ClassWork.week3.desing_patterns.social_network.observer.itStudent;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class TestObserver {

    public static void main(String[] args) {

        EducationSystemController controller = new EducationSystemController();

        controller.sibscribe(new itStudent());
        controller.sibscribe(new Gumanitaty());

        controller.notifyAll("Hey new course");
    }
}
