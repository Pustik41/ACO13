package HomeWork.week2.Library.test;

import HomeWork.week2.Library.DefaultLib;
import HomeWork.week2.Library.base.Library;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class TestLibrary {

    public static void main(String[] args) {

        Library lib2 = new DefaultLib().createLib();

        System.out.println(lib2.showAvailablePrints());

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
