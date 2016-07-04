package ClassWork.week3.desing_patterns.social_network.twitter;

import ClassWork.week3.desing_patterns.social_network.EducationSystemController;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class TestAdapter {

    public static void main(String[] args) {

        EducationSystemController systemController = new EducationSystemController();

        systemController.setSocialNetworkApi(new TwitterSocialNetworckAdapter(new TwitterApi()));
    }
}
