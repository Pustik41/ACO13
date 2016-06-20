package HomeWork.week2.Library;

import HomeWork.week2.Library.base.*;

/**
 * Created by zhabenya on 19.06.16.
 */
public class DefaultLib {

    public static Library createLib(){

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

        return lib;
    }
}
