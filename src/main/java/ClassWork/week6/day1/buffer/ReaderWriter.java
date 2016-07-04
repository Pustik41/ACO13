package ClassWork.week6.day1.buffer;

import java.io.*;

/**
 * Created by zhabenya on 02.07.16.
 */
public class ReaderWriter {

    public static void main(String[] args) throws IOException {

        InputStream inputStream =new BufferedInputStream( new FileInputStream("/home/tania/IdeaProjects/ArtCode/ACO13/src/main.java.ClassWork/week6/Test2.txt"));

        /*int readByte;

        while ((readByte = inputStream.read()) != -1){
            System.out.print((char) readByte);
        }*/

        Reader reader =new BufferedReader(
                    new FileReader("/home/tania/IdeaProjects/ArtCode/ACO13/src/main.java.ClassWork/week6/Test2.txt"));

        reader.read();

        int readChar;

        while ((readChar = inputStream.read()) != -1){
            System.out.print(readChar + " ");
        }
    }
}
