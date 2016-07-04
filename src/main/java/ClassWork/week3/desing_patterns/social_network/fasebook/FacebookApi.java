package ClassWork.week3.desing_patterns.social_network.fasebook;

import ClassWork.week3.desing_patterns.social_network.common.SocialNetworkApi;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class FacebookApi implements SocialNetworkApi {

    @Override
    public  String logint( String name, String pass){
        return "facebook key";
    }

    @Override
    public int createGroup(String name){
        System.out.println("Fasebook group - " + name);
        return 1;
    }

    public FacebookGroup get(int id){

        return new FacebookGroup();
    }
}
