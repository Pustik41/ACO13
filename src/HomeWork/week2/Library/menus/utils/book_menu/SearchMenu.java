package HomeWork.week2.Library.menus.utils.book_menu;

import HomeWork.week2.Library.base.Author;
import HomeWork.week2.Library.base.Library;
import HomeWork.week2.Library.base.Prints;
import HomeWork.week2.Library.menus.MainMenu;
import HomeWork.week2.Library.menus.PrintsMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by dfsdfsddfsdf on 29.06.16.
 */
public class SearchMenu {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String choice;
    private String title;
    private int year;
    private Author author;

    public void searchMenu(Library lib){

        System.out.println("\nSearch Menu " + "\nMake your choice:");
        System.out.println("1 - Search by Title" + "\n2 - Search by year" + "\n3 - Search by Author");
        System.out.println("back - return previous menu" + "\nreturn - return to main menu"
                            + "\nexit - exit from program");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice){
            case "1":
                searchByTitle(lib);
                break;

            case "2":
                searchByYear(lib);
                break;

            case "3":
                searchByAuthor(lib);
                break;

            case "back":
                new PrintsMenu().printsMenu(lib);
                break;

            case "return":
                new MainMenu().mainMenu(lib);
                break;

            case "exit":
                System.out.println("Exit from program");
                break;

            default:
                System.out.println("ooops");
                searchMenu(lib);
                break;
        }

    }

    public void searchByTitle(Library lib){

        System.out.println("Enter print title");

        try {
            title = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Prints> prints = lib.searchPrintsByTitle(title);

        if(prints != null){
            new ShowListPrints().listOfPrintsFound(prints, lib);
            return;
        }

        System.out.println("No results found");
        searchMenu(lib);

    }

    public void searchByYear(Library lib){

        System.out.println("Enter the year of release of the book");

        try {
            year = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Wrong data try again");
            searchByYear(lib);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Prints> prints = lib.searchPrintsByYear(year);

        if(prints != null){
            new ShowListPrints().listOfPrintsFound(prints, lib);
            return;
        }

        System.out.println("No results found");
        searchMenu(lib);
    }

    public void searchByAuthor(Library lib){

        String name = "";
        String surName = "";

        System.out.println("Enter name Author");

        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter surname Author");

        try {
            surName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        author = new Author(name, surName);

        List<Prints> prints = lib.searchPrintsByAuthor(author);

        if(prints != null){
            new ShowListPrints().listOfPrintsFound(prints, lib);
            return;
        }

        System.out.println("No results found");
        searchMenu(lib);
    }
}
