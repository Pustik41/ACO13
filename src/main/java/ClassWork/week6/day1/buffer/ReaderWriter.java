package ClassWork.week6.day1.buffer;

import java.io.*;

/**
 * Created by zhabenya on 02.07.16.
 */
public class ReaderWriter {


        public static void main(String[] args) throws IOException {
            InputStream is = new BufferedInputStream(
                    new FileInputStream("/Users/dfsdfsddfsdf/IdeaProjects/ACO13/src/main/java/ClassWork/week6/Test2.txt"));


        /*int readByte;
        while ((readByte = is.read()) != -1){
            System.out.print((char) readByte);
        }*/


            Reader reader = new BufferedReader(
                    new FileReader("/Users/dfsdfsddfsdf/IdeaProjects/ACO13/src/main/java/ClassWork/week6/Test2.txt"));


            int readChar;
            while ((readChar = reader.read()) != -1) {
                System.out.print(readChar + " ");
            }


        }

}
