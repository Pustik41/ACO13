package HomeWork.week2.Library;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class TestLibrary {

    public static void main(String[] args) {

        Library lib = new Library("TestLibrary", 345_28_35);

        Prints bk1 = new Book("Inferno", new Author("Dan", "Brown"), 2013, 654);
        Prints mag1 = new Magazine("Rolling Stone", new Author("Jann", "Wenner"), 2016, 35);
        Prints bk2 = new Book("Nous les dieux", new Author("Bernard", "Werber"), 2004, 612);
        Prints mag2 = new Magazine("Rolling Stone", new Author("Jann", "Wenner"), 2015, 38);
        Prints bk4 = new Book("The Divine Comedy", new Author("Dante", "Alighieri"), 1998, 654);
        Prints bk3 = new Book("The Lost Symbol", new Author("Dan", "Brown"), 2009, 684);
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

        //lib.showClients();

        lib.issuePrints(cl1, bk1);
        lib.issuePrints(cl1, bk2);
        lib.issuePrints(cl1, mag2);
        lib.issuePrints(cl2, bk3);


        lib.returnPrints(cl1, bk1);
        lib.returnPrints(cl2, bk3);


        System.out.println();
        lib.showPtins();


        System.out.println();
        lib.showPrintsInOut();

        System.out.println("\nSerch prints by Author");
        lib.showPrintsByAuthor( new Author("Dan", "Brown"));


    }
}
