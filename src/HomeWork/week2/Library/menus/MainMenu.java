package HomeWork.week2.Library.menus;

import HomeWork.week2.Library.base.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dfsdfsddfsdf on 23.06.16.
 */
public class MainMenu {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String choice;

    void mainMenu(Library lib){

        System.out.println("Welcome to Menu Library");
        System.out.println("Make your choice:\n");
        System.out.println("1 - Client menu");
        System.out.println("2 - Book menu");
        System.out.println("exit - Exit from program");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice){

            case "1":
                new ClientMenu().clientMenu(lib);
                break;

            case "2":
                System.out.println("Book menu");
                break;

            case "exit":
                System.out.println("Goodbye!!!");
                break;

            default:
                System.out.println("Do some choice");
                mainMenu(lib);
                break;
        }

    }
}
