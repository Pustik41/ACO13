package ClassWork.week3.desing_patterns.social_network.twitter;

import ClassWork.week3.desing_patterns.social_network.common.SocialNetworkApi;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class TwitterSocialNetworckAdapter implements SocialNetworkApi {

    private TwitterApi twitterApi;

    public TwitterSocialNetworckAdapter(TwitterApi twitterApi) {
        this.twitterApi = twitterApi;
    }

    @Override
    public String logint(String name, String pass) {
        return null;
    }

    @Override
    public int createGroup(String name) {

        String postId = twitterApi.createPost(name);

        String intValue = postId.split("=")[1];

        return Integer.parseInt(intValue);
    }
}
