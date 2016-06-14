package ClassWork.week3.desing_patterns.social_network;

import ClassWork.week1.day2.Student.Student;
import ClassWork.week3.desing_patterns.social_network.common.SocialNetworkApi;
import ClassWork.week3.desing_patterns.social_network.observer.ISubscribe;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dfsdfsddfsdf on 14.06.16.
 */
public class EducationSystemController {

        private List<ISubscribe> subscribeList = new ArrayList<>();

        private SocialNetworkApi socialNetworkApi = SocialNetworkApiFacroty.create();


        public int createCourse(Course course){
            return socialNetworkApi.createGroup("Name");
        }

        public String login(String email, String pass){
            return socialNetworkApi.logint(email, pass);
        }

        public Course getCourse(int id){
            return null;
        }



    public void sibscribe(ISubscribe subscribe){
        subscribeList.add(subscribe);
    }

    public  void notifyAll(String massege){

        for (ISubscribe sb: subscribeList) {
            sb.notify(massege);
        }
    }

    public SocialNetworkApi getSocialNetworkApi() {
        return socialNetworkApi;
    }

    public void setSocialNetworkApi(SocialNetworkApi socialNetworkApi) {
        this.socialNetworkApi = socialNetworkApi;
    }
}
