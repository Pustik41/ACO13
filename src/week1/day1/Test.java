package week1.day1;

/**
 * Created by zhabenya on 21.05.16.
 */
public class Test {

    public static void main(String[] args) {

        Human person = new Human("Vasja", 32, "men", 85, 180);

        //.init("Vasja", 32, "men", 85, 180);

        /*person.name = "Vasja";
        person.age = 25;*/

        /*String personInfo = person.asString();
        System.out.println(personInfo);*/
        person.setName("Lok");

        System.out.println(person.getName());

        System.out.println(person.asString());

    }

}
