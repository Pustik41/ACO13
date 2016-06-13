package HomeWork.week2.Library;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class TestLibrary {

    public static void main(String[] args) {

        Library lib = new Library("TestLibrary", 345_28_35);

        Author ar1 = new Author("Dan", "Brown");
        Author ar2 = new Author("Jann", "Wenner");
        Author ar3 = new Author("Bernard", "Werber");
        Author ar4 = new Author("Dante", "Alighieri");


        Prints bk1 = new Book("Inferno", ar1, 2013, 654);
        Prints mag1 = new Magazine("Rolling Stone", ar2, 2016, 35);
        Prints bk2 = new Book("Nous les dieux", ar3, 2004, 612);
        Prints mag2 = new Magazine("Rolling Stone", ar2, 2015, 38);
        Prints bk3 = new Book("The Divine Comedy", ar4, 1998, 654);
        Prints bk4 = new Book("The Lost Symbol", ar1, 2009, 684);
        Prints bk5 = null;


        Client cl1 = new Client("Stiv", "Gardner", 295_48_25);
        Client cl2 = new Client("Frenk", "Lourens", 245_28_65);
        Client cl3 = new Client("Bob", "Riger", 385_75_84);
        Client cl4 = new Client("John", "Min", 876_42_94);
        Client cl5 = new Client("Bob", "Lee", 983_63_19);

        lib.addPrints(bk1);
        lib.addPrints(bk2);
        lib.addPrints(bk3);
        lib.addPrints(bk4);
        lib.addPrints(mag1);
        lib.addPrints(mag2);

        //lib.addPrints(bk5); // null

        lib.addClient(cl1);
        lib.addClient(cl2);
        lib.addClient(cl3);
        lib.addClient(cl4);
        lib.addClient(cl5);

        lib.addBlackList(cl5);

        lib.showClients();

        lib.issuePrints(cl1, bk1);
        lib.issuePrints(cl1, bk2);
        lib.issuePrints(cl1, mag2);
        lib.issuePrints(cl2, bk3);


        lib.returnPrints(cl1, bk2);
        lib.returnPrints(cl2, bk3);


        System.out.println();
        lib.showPrints();

        System.out.println();
        lib.showAuthorList();


        /*
        System.out.println();
        lib.showPrintsInOut();

        System.out.println("\nSerch prints by Author");
        lib.showPrintsByAuthor(ar1);*/


    }
}
