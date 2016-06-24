package HomeWork.week2.Library.menus;

import HomeWork.week2.Library.base.Library;
import HomeWork.week2.Library.base.Prints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by dfsdfsddfsdf on 24.06.16.
 */
public class BookMenu {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String choice;

    public void bookMenu(Library lib){

        System.out.println("Book menu");
        System.out.println("\nMake you choice");
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
                System.out.println("Prints");
                break;

            case "2":
                System.out.println("Need");
                break;

            case "3":

                List<Prints> prints =  lib.showPrintsInOut();
                int countCopy = 1;

                for (int i = 0; i < prints.size() ; i++) {

                    for (int j = i + 1; j < prints.size() ; j++) {

                        if (prints.get(j).equals(prints.get(i))){
                            countCopy++;
                        }
                    }

                    System.out.println(prints.get(i) + "Issued  " + countCopy + " copies");

                    i = i + countCopy - 1;
                    countCopy = 1;
                }
                break;

            case "4":
                System.out.println("Search");
                break;

            case "5":
                System.out.println("add book");
                break;

            case "return":
                new MainMenu().mainMenu(lib);
                break;

            case "exit":
                System.out.println("Exit from programm");
                break;

            default:
                System.out.println("ooops");
                bookMenu(lib);
                break;
        }

    }
}
