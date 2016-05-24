package HomeWork.week1;

/**
 * Created by dfsdfsddfsdf on 24.05.16.
 */
public class Test {
    public static void main(String[] args) {

        char[] mas = {'V', 'a', 's', 'j', 'a'};

        String str1 = "      ";
        String str2 = "Vasjx";

        MyString name1= new MyString(str1);
        MyString name2 = new MyString(str2);
        MyString name3 = name1.concat(name2);

    }
}
