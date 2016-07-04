package ClassWork.week5.day2.clone;

import java.io.*;

/**
 * Created by zhabenya on 26.06.16.
 */
public class Copying {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Child child = new Child("Ivassik", 12);
        Woman woman = new Woman("Anna", 35, child);
        Man person = new Man("Vasja", 45, woman);


        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream
                ("/home/tania/IdeaProjects/ArtCode/ACO13/src/main.java.ClassWork/week5/day2/clone/Man.txt")));


//        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream
//                ("/home/tania/IdeaProjects/ArtCode/ACO13/src/main.java.ClassWork/week5/day2/clone/Man.txt")));

        oos.writeObject(person);
        oos.flush();
        oos.close();

        /*Man clone = (Man) ois.readObject();
        ois.close();

        System.out.println(person);
        System.out.println(clone);

        person.setAge(25);
        System.out.println("---------After clone------");

        System.out.println(person);
        System.out.println(clone);*/

    }
}
