package ClassWork.week6.day1.recursion;

/**
 * Created by zhabenya on 02.07.16.
 */
public class RecursionIntro {

    public static void main(String[] args) {

        a(15);
    }

    private static void a(int i) {

        if(i == 0) return;

        a(i - 1);
        System.out.println(i);
    }
}
