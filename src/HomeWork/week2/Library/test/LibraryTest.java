package HomeWork.week2.Library.test;

import HomeWork.week2.Library.base.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dfsdfsddfsdf on 21.06.16.
 */
public class LibraryTest {

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
    Prints bk5 = new Book("Inferno", ar5, 1987, 310);
    Prints mag1 = new Magazine("Rolling Stone", ar2, 2016, 35, 1);
    Prints mag2 = new Magazine("Rolling Stone", ar2, 2009, 38, 1);
    Prints mag3 = new Magazine("Rolling Stone", ar2, 2016, 35, 2);

    Client cl1 = new Client("Stiv", "Gardner", "044_295_48_25");
    Client cl2 = new Client("Frenk", "Lourens", "044_245_28_65");
    Client cl3 = new Client("Bob", "Riger", "044_385_75_84");
    Client cl4 = new Client("John", "Min", "044_876_42_94");
    Client cl5 = new Client("Bob", "Lee", "044_983_63_19");


    @Before
    public void setUp() throws Exception {

        lib.addPrint(bk1);
        lib.addPrint(bk1);
        lib.addPrint(bk1);
        lib.addPrint(bk2);
        lib.addPrint(bk3);
        lib.addPrint(bk4);
        lib.addPrint(bk5);
        lib.addPrint(mag1);
        lib.addPrint(mag2);
        lib.addPrint(mag3);

        lib.addClient(cl1);
        lib.addClient(cl2);
        lib.addClient(cl3);
        lib.addClient(cl4);
        lib.addClient(cl5);
    }

    @Test
    public void testAddPrint() throws Exception {
        //Prints bk6 = new Book("Inferno", ar1, 2009, 654);
        Prints bk7 = null;
        assertEquals(false, lib.addPrint(bk7));
    }

    @Test
    public void testAddClient() throws Exception {
       Client cl7 = new Client("Bob", "Lee", "044_983_63_19");
        assertEquals(false, lib.addClient(cl7));
    }

    @Test
    public void testAddToBlackList() throws Exception {
        Client cl7 = new Client("Bob", "Lee", "044_983_63_19");
        assertEquals(true, lib.addToBlackList(cl7));
    }

    @Test
    public void testRemovePrint() throws Exception {
        Prints bk6 = new Book("Inferno", ar1, 2009, 654);
        // for test false Prints bk7 = new Book("Inferno", ar1, 2009, 653);
        assertEquals(true, lib.removePrint(bk6));
    }

    @Test
    public void testRemoveFromBlacklist() throws Exception {
        testAddToBlackList();
        assertEquals(true, lib.removeFromBlacklist(cl5));
    }

    @Test
    public void testIssuePrints() throws Exception {
        Prints bk6 = new Book("Inferno", ar1, 2009, 654);
        Client cl7 = new Client("Bob", "Lee", "044_983_63_19");

        // for test when client have copy this print (result = false)
        // lib.issuePrints(cl7,bk1);

        /* for test when client have 3 print(result = false) lib.issuePrints(cl7, bk2);
        lib.issuePrints(cl7, bk3);
        lib.issuePrints(cl7, bk4);*/

        // for test when client in black list (result = false)
        // testAddToBlackList();

        assertEquals(true, lib.issuePrints(cl7, bk6));
    }

    @Test
    public void testReturnPrints() throws Exception {
        Prints bk6 = new Book("Inferno", ar1, 2009, 654);
        Client cl7 = new Client("Bob", "Lee", "044_983_63_19");
        lib.issuePrints(cl5, bk1);
        assertEquals(true, lib.returnPrints(cl7, bk6));
    }

    @Test
    public void testRemoveAllPrintCopies() throws Exception {
        Prints bk6 = new Book("Inferno", ar1, 2009, 654);
        assertEquals(true, lib.removeAllPrintCopies(bk6));
    }

}