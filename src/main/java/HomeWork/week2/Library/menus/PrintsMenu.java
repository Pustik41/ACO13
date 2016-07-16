package HomeWork.week2.Library.menus;

import HomeWork.week2.Library.base.Author;
import HomeWork.week2.Library.base.Library;
import HomeWork.week2.Library.base.Prints;
import HomeWork.week2.Library.menus.utils.book_menu.SearchMenu;
import HomeWork.week2.Library.menus.utils.book_menu.ShowListPrints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dfsdfsddfsdf on 24.06.16.
 */
public class PrintsMenu {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String choice;


    public void printsMenu(Library lib){

        System.out.println("\nBook menu");
        System.out.println("Make you choice");
        System.out.println("1 - Show a list of available prints" + "\n2 - Show a list of books that ended" +
                            "\n3 - Show a list of prints issued" + "\n4 - Print search" + "\nadd - add new print");
        System.out.println("return - return to the main menu" + "\nexit - exit from program");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice){

            case "1":
                new ShowListPrints().showAvailablePrints(lib);
                break;

            case "2":
                Library tmp = new ShowListPrints().showPrintsNeeded(lib);
                if(tmp != null) {
                    printsMenu(tmp);
                }
                break;

            case "3":
                new ShowListPrints().showPrintsInOut(lib);
                break;

            case "4":
                new SearchMenu().searchMenu(lib);
                break;

            case "add":
                addPrint(lib);
                printsMenu(lib);
                break;

            case "return":
                new MainMenu().mainMenu(lib);
                break;

            case "exit":
                System.out.println("Exit from programm");
                break;

            default:
                System.out.println("ooops");
                printsMenu(lib);
                break;
        }

    }

    private Library addPrint(Library lib){
        String title = "";
        Author author = null;
        String nameAuthor = "";
        String surNameAuthor = "";
        int year = 0;
        int numOfPage = 0;

        System.out.println("Enter title");
        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter name Author");
        try {
            nameAuthor = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter surname Author");
        try {
            surNameAuthor = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter year");
        try {
            year = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Wrong date try again");
            addPrint(lib);
            return lib;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter number of pages");
        try {
            numOfPage = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Wrong date try again");
            addPrint(lib);
            return lib;
        } catch (IOException e) {
            e.printStackTrace();
        }

        author = new Author(nameAuthor, surNameAuthor);

        Prints print = new Prints(title, author, year, numOfPage);

        lib.addPrint(print);

        return lib;
    }


}
