package ClassWork.week3.desing_patterns.social_network;

import ClassWork.week3.desing_patterns.social_network.common.SocialNetworkApi;
import ClassWork.week3.desing_patterns.social_network.common.SocialNetworkProxy;
import ClassWork.week3.desing_patterns.social_network.vk.PowerPoint;
import ClassWork.week3.desing_patterns.social_network.vk.VkApi;
import ClassWork.week3.desing_patterns.social_network.vk.VkServer;

/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class SocialNetworkApiFacroty {


    public  static SocialNetworkApi create(){
        return new SocialNetworkProxy(new VkApi(new VkServer(new PowerPoint(220, " USA"), "i7", 128, 3000)));
    }
}
