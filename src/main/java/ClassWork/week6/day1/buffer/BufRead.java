package ClassWork.week6.day1.buffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by zhabenya on 02.07.16.
 */
public class BufRead {

        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            String s = bf.readLine();
            System.out.println(s);


        }

}
