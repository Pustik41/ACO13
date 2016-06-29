package HomeWork.week2.Library.menus.utils.book_menu;

import HomeWork.week2.Library.base.Client;
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
public class PrintMenu {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String choice;

    public void printMenu(Prints print, Library lib){

        System.out.println("Print Menu");
        System.out.println("Make your choice:" + "\n1 - Issue print" + "\n2 - Delete copy of the print"
                             + "\n3 - Delete all copies of the print" + "\nadd - Add copy of the print");
        System.out.println("\nreturn - return to the main menu" + "\nexit - exit from program");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice){

            case "1":
                new IssuePrintForClient().issuePrint(lib, print);
                break;

            case "2":
                lib.removePrint(print);
                new PrintsMenu().printsMenu(lib);
                break;

            case "3":
                lib.removeAllPrintCopies(print);
                new PrintsMenu().printsMenu(lib);
                break;

            case "add":
                lib.addPrint(print);
                new PrintsMenu().printsMenu(lib);
                break;

            case "return":
                new PrintsMenu().printsMenu(lib);
                break;

            case "exit":
                System.out.println("Exit from program");
                break;

            default:
                System.out.println("ooops");
                printMenu(print, lib);
                break;
        }
    }
}

class IssuePrintForClient{

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String choice;

    public void issuePrint(Library lib, Prints print){

        System.out.println();

        Client client = listClients(lib);

        if(client != null && client.getInBlackList()){
            System.out.println("This client in black list." + "\nDo you want remove him from black lis - yes/no?");
            System.out.println("If yes - print will automatically give the client and you return to Main menu"
                    + "\nIf no - you return to Main menu");

            try {
                choice = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (choice){

                case "yes":
                    lib.removeFromBlacklist(client);
                    break;

                case "no":
                    new PrintsMenu().printsMenu(lib);
                    break;

                default:
                    issuePrint(lib, print);
                    break;
            }

        }

        lib.issuePrints(client, print);
        new PrintsMenu().printsMenu(lib);
        return;

    }

    private Client listClients(Library lib){

        System.out.println("List of Client");
        System.out.println("If the client is not in the black, after the selection of " +
                            "books will automatically give the client");

        List<Client> clients = lib.showClients();

        for (int i = 1; i <= clients.size() ; i++) {
            System.out.println(i + " - " + clients.get(i -1));
        }


        System.out.println("\nreturn - return to main menu");
        System.out.println("exit - exit from program");


        try {

            choice = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            int num = Integer.parseInt(choice);

            if(num > 0 &&  num <= clients.size()){
                return clients.get(num - 1);
            }

        }catch (NumberFormatException ex){}

        switch (choice){

            case "return":
                new MainMenu().mainMenu(lib);
                break;

            case "exit":
                System.out.println("Exit");
                break;
            default:
                System.out.println("oops");
                return listClients(lib);

        }

        return null;
    }
}
