package ClassWork.week2.day1.Inheart;

/**
 * Created by zhabenya on 28.05.16.
 */
public class TestCompany {

    public static void main(String[] args) {

        Employee coder = new Coder(25, "Vasja", "Rogozov", "Java");
        Employee tester = new QA(23, "Serg", "kol", 100);
        Employee juniour = new Junior(21, "Jhon", "Fla", "Java");
        Employee middle = new Middle(24, "Georg", "Ibrahim", "Java");


        Employee[] employs= new Employee[15];
        employs[0] = coder;
        employs[1] = tester;
        employs[2] = juniour;
        employs[3] = middle;

        Employee manager = new Manager(36, "Ivan", "Korchi",employs);
        manager.work();
        System.out.println(manager.asString());

        //System.out.println(coder.asString());
    }
}
