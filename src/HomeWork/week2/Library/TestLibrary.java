package HomeWork.week2.Library;

import HomeWork.week2.Library.base.*;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class TestLibrary {

    public static void main(String[] args) {

        Library lib = new Library("TestLibrary", "044_345_28_35");

        Author ar1 = new Author("Dan", "Brown");
        Author ar2 = new Author("Jann", "Wenner");
        Author ar3 = new Author("Bernard", "Werber");
        Author ar4 = new Author("Dante", "Alighieri");
        Author ar5 = new Author("Sara", "Swift");


        Prints bk1 = new Book("Inferno", ar1, 2009, 654);
        Prints bk2 = new Book("Nous les dieux", ar3, 2004, 612);
        Prints bk3 = new Book("The Divine Comedy", ar4, 1998, 654);
        Prints bk4 = new Book("The Lost Symbol", ar1, 2015, 684);
        Prints mag1 = new Magazine("Rolling Stone", ar2, 2016, 35, 1);
        Prints mag2 = new Magazine("Rolling Stone", ar2, 2009, 38, 1);
        Prints mag3 = new Magazine("Rolling Stone", ar2, 2016, 35, 2);
        Prints bk5 = new Book("Inferno", ar5, 1987, 310);
        Prints bk6 = new Book("Inferno", ar1, 2009, 654);
        //Prints bk6 = null;


        Client cl1 = new Client("Stiv", "Gardner", "044_295_48_25");
        Client cl2 = new Client("Frenk", "Lourens", "044_245_28_65");
        Client cl3 = new Client("Bob", "Riger", "044_385_75_84");
        Client cl4 = new Client("John", "Min", "044_876_42_94");
        Client cl5 = new Client("Bob", "Lee", "044_983_63_19");
        Client cl6 = new Client("Bob", "Lee", "044_983_63_12");

        lib.addPrints(bk1);
        lib.addPrints(bk2);
        lib.addPrints(bk3);
        lib.addPrints(bk4);
        lib.addPrints(mag1);
        lib.addPrints(mag2);
        lib.addPrints(bk1);
        lib.addPrints(bk1);
        lib.addPrints(bk5);
        lib.addPrints(bk6);
        lib.addPrints(bk6);
        lib.addPrints(mag3);
        lib.addPrints(mag2);
        lib.addPrints(mag3);


        //lib.addPrints(bk6); // null

        lib.addClient(cl1);
        lib.addClient(cl2);
        lib.addClient(cl3);
        lib.addClient(cl4);
        lib.addClient(cl5);
        lib.addClient(cl6);

        lib.showClients();

        lib.addToBlackList(cl5);

        System.out.println();
        lib.showAvailablePrints();

        lib.delBlackList(cl5);



        lib.issuePrints(cl1, bk1);
        lib.issuePrints(cl1, bk2);
        lib.issuePrints(cl1, mag2);
        lib.issuePrints(cl2, bk3);
        lib.issuePrints(cl3, bk1);
        lib.issuePrints(cl4, bk1);
        lib.issuePrints(cl2, bk1);
        lib.issuePrints(cl5, bk1);

        System.out.println();
        lib.showPrintsInOut();

        System.out.println();
        lib.showNeededPrints();

        System.out.println();
        lib.showAvailablePrints();

    }
}
