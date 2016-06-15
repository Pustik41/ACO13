package week3.day1.equals.symmetry;

import java.util.ArrayList;
import java.util.List;

public class TestSymmetry {
    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println("s.equals(cis) -> " + s.equals(cis));
        System.out.println("cis.equals(s) -> " + cis.equals(s));

        List<CaseInsensitiveString> list =
                new ArrayList<>();
        list.add(cis);

        System.out.println("list.contains(s) -> " + list.contains(s));
    }
}
