package HomeWork.week2.Library.menus;

import HomeWork.week2.Library.base.Client;
import HomeWork.week2.Library.base.Library;
import HomeWork.week2.Library.base.Prints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by dfsdfsddfsdf on 22.06.16.
 */
 class ClientMenu  {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String choice;
    String name;
    String surName;
    String numTel;
    Library lib;

    public void clientMenu(Library lib) {

        System.out.println("Client menu:\n" + "Make your choice:\n");

        this.lib = lib;
        List<Client> clients = lib.showClients();

        for (int i = 1; i <= clients.size() ; i++) {
            System.out.println(i + " - " + clients.get(i -1));
        }

        System.out.println("add - add client");
        System.out.println("clear - clear clients list");
        System.out.println("return - return to main menu");
        System.out.println("exit - exit from program");


        try {

            choice = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            int num = Integer.parseInt(choice);

            if(num > 0 &&  num <= clients.size()){
                clientFunctions(clients.get(num - 1), lib);
                return;
            }

        }catch (NumberFormatException ex){}

        switch (choice){

            case "add":
                try {

                    System.out.println("Enter the name of the client:");
                    name = reader.readLine();
                    System.out.println("Enter the surname of the client:");
                    surName = reader.readLine();
                    System.out.println("Enter the telephone number of the client:");
                    numTel = reader.readLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                lib.addClient(new Client(name, surName, numTel));
                clientMenu(lib);
                break;

            case "clear":
                lib.clearLibraryOfClients();
                clientMenu(lib);
                break;

            case "return":
                new MainMenu().mainMenu(lib);
                break;

            case "exit":
                System.out.println("Exit");
                break;
            default:
                System.out.println("oops");
                clientMenu(lib);
                break;
        }

    }

    private void clientFunctions(Client client, Library lib){

        System.out.println("Make your choice");
        System.out.println("1 - get status client." + "\n2 - add to black list" + "\n3 - deleted from black list");
        System.out.println("4 - issue book" + "\n5 - return book" + "\nback - return previous menu");
        System.out.println("return - return to the main menu" + "\nexit - exit from program");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice){
            case "1":

                if(client.getInBlackList()){
                    System.out.println("Client in black list");
                    clientFunctions(client,lib);
                    break;

                } else{
                    System.out.println("Client is not in black list ");
                    clientFunctions(client, lib);
                }
                break;

            case "2":
                lib.addToBlackList(client);
                System.out.println("Сlient added to the black list");
                clientFunctions(client, lib);
                break;

            case "3":
                lib.removeFromBlacklist(client);
                System.out.println("Client is removed from the blacklist");
                clientFunctions(client, lib);
                break;

            case "4":
                Prints print = showAvailablePrints(lib);
                if(print != null){
                    lib.issuePrints(client, print);
                    clientFunctions(client, lib);
                }
                break;

            case "5":
                print = showClientPrints(client);
                if(print != null){
                    lib.returnPrints(client, print);
                }
                clientFunctions(client, lib);
                break;

            case "back":
                clientMenu(lib);
                break;

            case "return":
                new MainMenu().mainMenu(lib);
                break;

            case "exit":
                System.out.println("Exit from programm");
                break;

            default:
                System.out.println("ooops");
                clientFunctions(client, lib);
                break;

        }
    }

    private Prints showAvailablePrints(Library lib){

        List<Prints> prints = lib.showAvailablePrints();

        for (int i = 1; i <= prints.size() ; i++) {
            System.out.println(i + " - " + prints.get(i - 1));
        }

        System.out.println("return - return to the main menu" + "\nexit - exit from program");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            int num = Integer.parseInt(choice);

            if(num > 0 &&  num <= prints.size()){
                return prints.get(num - 1);
            }

        }catch (NumberFormatException ex){}

        switch (choice){

            case "return":
                new MainMenu().mainMenu(lib);
                break;

            case "exit":
                System.out.println("Exit from programm");
                break;
// todo Displays oops choose the right and is activated break;
            default:
                System.out.println("ooops");
                showAvailablePrints(lib);
                break;
        }

        return null;
    }

    private Prints showClientPrints(Client client){

        Prints print = null;
        List<Prints> prints = client.getClientPrints();

        if(prints.size() != 0) {

            for (int i = 1; i <= prints.size(); i++) {

                System.out.println(i + " - " + prints.get(i - 1));
            }

            try {
                choice = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {

                int num = Integer.parseInt(choice);

                if (num > 0 && num <= prints.size()) {
                    return prints.get(num - 1);
                }
            }catch (NumberFormatException ex){}
        }

        System.out.println("Client don't have any print");
        return null;
    }

}
