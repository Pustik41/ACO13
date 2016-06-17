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



        Client cl1 = new Client("Stiv", "Gardner", "044_295_48_25");
        Client cl2 = new Client("Frenk", "Lourens", "044_245_28_65");
        Client cl3 = new Client("Bob", "Riger", "044_385_75_84");
        Client cl4 = new Client("John", "Min", "044_876_42_94");
        Client cl5 = new Client("Bob", "Lee", "044_983_63_19");
        Client cl6 = new Client("Bob", "Lee", "044_983_63_12");

        lib.addPrint(bk1);
        lib.addPrint(bk2);
        lib.addPrint(bk3);
        lib.addPrint(bk4);
        lib.addPrint(mag1);
        lib.addPrint(mag2);
        lib.addPrint(bk1);
        lib.addPrint(bk1);
        lib.addPrint(bk5);
        lib.addPrint(bk6);
        lib.addPrint(bk6);
        lib.addPrint(mag3);
        lib.addPrint(mag2);
        lib.addPrint(mag3);


        lib.addClient(cl1);
        lib.addClient(cl2);
        lib.addClient(cl3);
        lib.addClient(cl4);
        lib.addClient(cl5);
        lib.addClient(cl6);


        System.out.println(lib.showAvailablePrints());

        lib.issuePrints(cl1, bk6);

        System.out.println(lib.showPrintsInOut());





/*
// test passed
        System.out.println("Black List:\n" + lib.showBlackList());
        Client cl7 = new Client("Stiv", "Gardner", "044_295_48_25");
        System.out.println("Does client add to BL - " + lib.addToBlackList(cl7));
        System.out.println("Black List:\n" + lib.showBlackList());
// test passed
        System.out.println("showPrintsInOut:\n" + lib.showPrintsInOut());
        Client cl8 = new Client("Stiv", "Gardner", "044_295_48_25");
        System.out.println("Does client take bookL - " + lib.issuePrints(cl8, bk1));
        System.out.println("showPrintsInOut:\n" + lib.showPrintsInOut());
// test passed
        System.out.println("showPrintsInOut:\n" + lib.showPrintsInOut());
        System.out.println("Does client take bookL - " + lib.issuePrints(cl2, bk6));
        System.out.println("showPrintsInOut:\n" + lib.showPrintsInOut());
// test passed
        System.out.println("Black List:\n" + lib.showBlackList());
        System.out.println("Does client add to BL - " + lib.addToBlackList(cl1));
        System.out.println("Black List:\n" + lib.showBlackList());
        System.out.println("Does client remove from BL - " + lib.removeFromBlacklist(cl7));
        System.out.println("Black List:\n" + lib.showBlackList());
// test return passed
        System.out.println("showPrintsInOut:\n" + lib.showPrintsInOut());
        Client cl9 = new Client("Frenk", "Lourens", "044_245_28_65");
        Prints bk7 = new Book("Inferno", ar1, 2009, 654);
        System.out.println("Does return  bookL - " + lib.returnPrints(cl9,bk7));
        System.out.println("showPrintsInOut:\n" + lib.showPrintsInOut());

// test removeAllPrintCopies passed
        Prints bk10 = new Book("Inferno", ar1, 2009, 654);
        lib.removeAllPrintCopies(bk10);
        System.out.println("Does client take bookL - " + lib.issuePrints(cl3,bk1));
        lib.addPrint(bk1);
        System.out.println(lib.searchPrints(bk1.getTitle()));
// test clearLibrariesPrints passed
        lib.clearLibrariesPrints();
        System.out.println("AvailablePrints:\n" + lib.showAvailablePrints());
        System.out.println("Does client take bookL - " + lib.issuePrints(cl4,bk1));
        lib.addPrint(bk1);
        System.out.println("AvailablePrints:\n" + lib.showAvailablePrints());
// test clearLibraryOfClients passed
        lib.clearLibraryOfClients();
        System.out.println("Show clients:\n" + lib.showClients());
        System.out.println("Does client take bookL - " + lib.issuePrints(cl4,bk1));
*/
    }
}
