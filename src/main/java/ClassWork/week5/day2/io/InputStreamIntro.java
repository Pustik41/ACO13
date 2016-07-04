package ClassWork.week5.day2.io;

import java.io.*;

/**
 * Created by zhabenya on 26.06.16.
 */
public class InputStreamIntro {

    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream
                ("/home/tania/IdeaProjects/ArtCode/ACO13/src/main.java.ClassWork/week5/day2/io/Test2.txt");
        OutputStream os = new FileOutputStream
                ("/home/tania/IdeaProjects/ArtCode/ACO13/src/main.java.ClassWork/week5/day2/io/Test3.txt");

        int readByte;

        while ((readByte = is.read()) != -1){
            os.write(readByte);
        }

    }
}
