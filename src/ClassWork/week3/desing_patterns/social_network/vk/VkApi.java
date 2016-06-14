package ClassWork.week3.desing_patterns.social_network.vk;

import ClassWork.week3.desing_patterns.social_network.common.SocialNetworkApi;
import ClassWork.week3.desing_patterns.social_network.fasebook.FacebookGroup;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class VkApi implements SocialNetworkApi {

    public VkServer  server;

    public VkApi(VkServer server) {
        this.server = server;
    }

    @Override
    public  String logint( String name, String pass){
        return "vk key";
    }
    @Override
    public int createGroup(String name){
        System.out.println("VK group - " + name);
        return 1;
    }

    public VkGroup get(int id){

        return new VkGroup();
    }
}
