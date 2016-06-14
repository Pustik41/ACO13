package ClassWork.week3.desing_patterns.social_network.common;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class SocialNetworkProxy implements SocialNetworkApi {


    private SocialNetworkApi target;

    public SocialNetworkProxy(SocialNetworkApi target) {
        this.target = target;
    }

    @Override
    public String logint(String name, String pass) {

        System.out.printf("mail %s, pass %s\n", name, pass);
        return target.logint(name, pass);
    }

    @Override
    public int createGroup(String name) {
        return 0;
    }
}
