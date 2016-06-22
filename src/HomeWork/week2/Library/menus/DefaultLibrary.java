package HomeWork.week2.Library.menus;

import HomeWork.week2.Library.base.*;

/**
 * Created by dfsdfsddfsdf on 22.06.16.
 */
  class DefaultLibrary {

      Library createLibrary(){

        Library defaultLib = new Library("TestLibrary", "044_345_28_35");

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

        defaultLib.addPrint(bk1);
        defaultLib.addPrint(bk1);
        defaultLib.addPrint(bk1);
        defaultLib.addPrint(bk2);
        defaultLib.addPrint(bk3);
        defaultLib.addPrint(bk4);
        defaultLib.addPrint(bk5);
        defaultLib.addPrint(mag1);
        defaultLib.addPrint(mag2);
        defaultLib.addPrint(mag3);

        defaultLib.addClient(cl1);
        defaultLib.addClient(cl2);
        defaultLib.addClient(cl3);
        defaultLib.addClient(cl4);
        defaultLib.addClient(cl5);

        return defaultLib;
    }
}
