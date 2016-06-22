package HomeWork.week2.Library.menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dfsdfsddfsdf on 22.06.16.
 */
public class MainMenu {

    private final String LOGIN = "Admin";
    private final String PASSWORD = "1234";
    private String userLogin;
    private String userPassword;
    private String choice;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public void startLibrary(){

        DefaultLibrary lib = new DefaultLibrary();
        lib.createLibrary();

        boolean isWork = true;

        System.out.println("Welcome to the library menu");
        System.out.println("Make your choice:");
        System.out.println("1 - Sing in");
        System.out.println("exit - Exit from program");

        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice) {

            case "1":
                if (checkLogPass()) {
                    goMenu();
                    break;
                }
                System.out.println("Wrong Login/Password");
                startLibrary();
                break;

            case "exit":
                System.out.println("Goodbye!!!");
                break;

            default:
                System.out.println("Do some choice");
                startLibrary();
                break;
        }

    }

    private void goMenu(){
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
                System.out.println("Client Menu");
                break;

            case "2":
                System.out.println("Book menu");
                break;

            case "exit":
                System.out.println("Goodbye!!!");
                break;

            default:
                System.out.println("Do some choice");
                goMenu();
                break;
        }

    }

    private boolean checkLogPass(){

        System.out.println("Login:");

        try {
            userLogin = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Password:");

        try {
            userPassword = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userLogin.equals(LOGIN) && userPassword.equals(PASSWORD);
    }
}

