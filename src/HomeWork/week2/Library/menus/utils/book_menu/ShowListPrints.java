package HomeWork.week2.Library.menus.utils.book_menu;

import HomeWork.week2.Library.base.Library;
import HomeWork.week2.Library.base.Prints;
import HomeWork.week2.Library.menus.PrintsMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by dfsdfsddfsdf on 29.06.16.
 */
public class ShowListPrints {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String choice;

    public void showPrintsInOut(Library lib){

        List<Prints> prints =  lib.showPrintsInOut();
        int countCopy = 1;

        if(prints.size() == 0){
            System.out.println("No prints issued");
        } else {

            for (int i = 0; i < prints.size(); i++) {

                for (int j = i + 1; j < prints.size(); j++) {

                    if (prints.get(j).equals(prints.get(i))) {
                        countCopy++;
                    }
                }

                System.out.println(prints.get(i) + "Issued  " + countCopy + " copies");

                i = i + countCopy - 1;
                countCopy = 1;
            }
        }

        System.out.println("back - return previous menu");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice){

            case "back":
                new PrintsMenu().printsMenu(lib);
                break;

            default:
                showPrintsInOut(lib);
                break;
        }
    }

    public Library  showPrintsNeeded(Library lib){

        System.out.println("Menu needed prints");
        System.out.println("Selecting a book, you automatically add a copy of it to the library" + "\nMake your choice");


        List<Prints> prints =  lib.showNeededPrints();

        for (int i = 1; i <= prints.size(); i++) {
            System.out.println(i + " - " + prints.get(i - 1));
        }

        System.out.println("\nback - return previous menu");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            int num = Integer.parseInt(choice);

            if(num > 0 &&  num <= prints.size()){
                lib.addPrint(prints.get(num - 1));
                return lib;
            }

        }catch (NumberFormatException ex){
            // NOP
        }

        switch (choice){

            case "back":
                new PrintsMenu().printsMenu(lib);
                break;

            default:
                return showPrintsNeeded(lib);
        }

        return null;
    }

    public void showAvailablePrints(Library lib){

        System.out.println("\nAvailable Prints Menu");
        System.out.println("Select a print to open the menu" + "\nMake your choice:");

        List<Prints> prints = lib.showAvailablePrints();

        for (int i = 1; i <= prints.size(); i++) {
            System.out.println(i + " - " + prints.get(i - 1) + ", Amount - " + prints.get(i - 1).getAmount());
        }

        System.out.println("\nback - return previous menu");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            int num = Integer.parseInt(choice);

            if(num > 0 &&  num <= prints.size()){
                new PrintMenu().printMenu(prints.get(num - 1), lib);
                return;
            }

        }catch (NumberFormatException ex){
            // NOP
        }

        switch (choice){

            case "back":
                new PrintsMenu().printsMenu(lib);
                break;

            default:
                System.out.println("ooops");
                showAvailablePrints(lib);
                break;

        }

    }

    public void listOfPrintsFound(List<Prints> prints, Library lib){

        System.out.println("\nFound Prints Menu");
        System.out.println("Select a print to open the menu" + "\nMake your choice:\n");

        for (int i = 1; i <= prints.size(); i++) {
            System.out.println("\n" + i + " - " + prints.get(i - 1) + ", Amount - " + prints.get(i - 1).getAmount());
        }

        System.out.println("back - return previous menu");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            int num = Integer.parseInt(choice);

            if(num > 0 &&  num <= prints.size()){
                new PrintMenu().printMenu(prints.get(num - 1), lib);
                return;
            }

        }catch (NumberFormatException ex){
            // NOP
        }

        switch (choice){

            case "back":
                new PrintsMenu().printsMenu(lib);
                break;

            default:
                System.out.println("ooops");
                listOfPrintsFound(prints, lib);
                break;

        }
    }

}
