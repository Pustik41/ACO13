package ClassWork.week5.day2.io.file_system;

import java.io.File;

/**
 * Created by zhabenya on 26.06.16.
 */
public class FileIntro {

    public static void main(String[] args) {

        File file = new File("/home/tania/IdeaProjects/ArtCode/ACO13/src/ClassWork/week5/day2/io/Test2.txt");
        File dir = new File("/home/tania/IdeaProjects/ArtCode/ACO13/src/ClassWork/week5/day2/io/file_system");

        System.out.println(file.isDirectory());
        System.out.println(dir.isDirectory());

        File[] files = dir.listFiles();
        for (File file1 : files) {
            System.out.println(file.getName());
        }
    }
}
