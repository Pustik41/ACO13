package ClassWork.week3.desing_patterns.social_network.test;

import ClassWork.week3.desing_patterns.social_network.EducationSystemController;
import ClassWork.week3.desing_patterns.social_network.fasebook.FacebookApi;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class TestStrategy {

    public static void main(String[] args) {

        EducationSystemController systemController = new EducationSystemController();

        String res2 = systemController.login("mail", "1234");
        System.out.println((res2));

        systemController.setSocialNetworkApi(new FacebookApi());
        String res = systemController.login("kokk", "1213");
        System.out.println(res);
    }
}
