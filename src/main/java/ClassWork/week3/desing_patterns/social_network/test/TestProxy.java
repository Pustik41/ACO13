package ClassWork.week3.desing_patterns.social_network.test;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */

import ClassWork.week3.desing_patterns.social_network.EducationSystemController;

public class TestProxy {

    public static void main(String[] args) {

        EducationSystemController controller = new EducationSystemController();

        String res = controller.login("lol23", "123");
        System.out.println(res);
    }
}
