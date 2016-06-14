package HomeWork.week2.Library.base;

import HomeWork.week2.Library.base.comp.ComparatorByNameClient;
import HomeWork.week2.Library.base.comp.ComparatorByTitle;
import HomeWork.week2.Library.base.comp.ComparatorByYear;

import java.util.ArrayList;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class Library {

    private String nameLibrary;
    private String numTelLib;

    private ArrayList<Prints> prints;
    private ArrayList<Client> clients;


    public Library(String nameLibrary, String numTelLib) {
        this.nameLibrary = nameLibrary;
        this.numTelLib = numTelLib;
        this.prints = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public boolean addPrints(Prints print){

        if(print != null){

            if(!prints.contains(print)) {

                prints.add(print);
                print.amountPrints++;

                return true;
            }

            print.amountPrints++;
            return true;
        }

        System.out.println("Prints can`t be added!!!");
        return false;
    }

    public boolean addClient(Client client){

        if(client != null && !clients.contains(client)) {

            return clients.add(client);
        }

        return false;
    }

    public boolean addToBlackList(Client client){

        if(client != null && client.getInBlackList() == false) {

            client.setInBlackList(true);

            return true;
        }

        return false;
    }

    public boolean delPrints(Prints print){

        if(print != null && prints.contains(print)){

            if(print.amountPrints - 1 > 0){

                print.amountPrints--;
                return true;
            }

            print.amountPrints--;
            return prints.remove(print);
        }

        return false;
    }

    public boolean delBlackList(Client client){

        if(client != null && client.getInBlackList() == true) {

            client.setInBlackList(false);

            return true;
        }

        return false;
    }

    public boolean issuePrints(Client client, Prints print){

        if(client != null && client.getInBlackList() == false && delPrints(print)){

            return client.addPrint(print);
         }

        return false;
    }

    public boolean returnPrints(Client client, Prints print){

        if(client != null && client.getClientPrints().contains(print) && addPrints(print)){
            client.delPrint(print);
            return true;
        }

        return false;
    }

    public void showBlackList(){

        System.out.println("Black List:");

        clients.sort(new ComparatorByNameClient());

        for (Client cl: clients) {

            if(cl.getInBlackList() == true) System.out.println(cl);
        }
    }

    public void showClients(){

        System.out.println("Clients List:");

        clients.sort(new ComparatorByNameClient());

        for (Client cl: clients) {

            System.out.println(cl);
        }
    }

    public void showPrints(){

        System.out.println("Prints List:");

        prints.sort(new ComparatorByTitle());

        for (Prints pr: prints) { System.out.println(pr + ", Amount - " + pr.amountPrints + ";");}

    }

    public void showClientPrints(Client client){

        if(client != null  && clients.contains(client)) {

            if (client.getCountClientPtints() > 0) {

                System.out.println(client.toString() + "\nHave " + client.getClientPrints().size() + " prints:");

                for (Prints pr : client.getClientPrints()) {

                    System.out.println(pr.toString());
                }

                return;
            }

            System.out.println(client.toString() + "\nDon`t have any prints");
        }
    }

    public void showPrintsInOut(){

        ArrayList<Prints> out = new ArrayList<>();

        System.out.println("Issued books:");

        for (Client cl: clients) {

            for (Prints pr: cl.getClientPrints()) {

                out.add(pr);
            }
        }

        if(out.size() > 0){

            out.sort(new ComparatorByTitle());

            for (int i = 0; i < out.size() ; i++) {

                int counterSame = 0;

                for (int j = i; j < out.size() ; j++) {

                    if(out.get(i).equals(out.get(j))){
                        counterSame++;
                    }
                }

                System.out.println(out.get(i) + ", Amount - " + counterSame + ";");

                i = i + counterSame - 1;
            }

            return;
        }

        System.out.println("Was mot issued any prints");
    }

    public void searchPrintsByAuthor(Author author){

        ArrayList<Prints> tmp = new ArrayList<>();

        for (Prints pr : prints) {

            if (author.equals(pr.getAuthor())) {
                tmp.add(pr);
            }
        }

        if(tmp.size() > 0) {

            tmp.sort(new ComparatorByTitle());

            for (Prints pr : tmp) {
                System.out.println(pr + ", Amount - " + pr.amountPrints + ";");
            }

            return;
        }

        System.out.println(author.toString() + " writer's book was not found");
    }

    public void searchPrintsByYear(int year){

        ArrayList<Prints> tmp = new ArrayList<>();

        for (Prints pr : prints) {

            if (year == pr.getYear()) {
                tmp.add(pr);
            }
        }

        if(tmp.size() > 0) {

            tmp.sort(new ComparatorByTitle());

            for (Prints pr : tmp) {
                System.out.println(pr + ", Amount - " + pr.amountPrints + ";");
            }

            return;
        }

        System.out.println("Prints of " + year + " was not found");
    }

    public ArrayList<Prints> searchPrints(String title){

        if(title != null){

            ArrayList<Prints> sameTitles = new ArrayList<>();

            prints.sort(new ComparatorByYear());

            for (Prints pr: prints) {
                if(pr.getTitle().equals(title)) {

                    System.out.println(pr + ", Amount - " + pr.amountPrints + ";");
                    sameTitles.add(pr);
                }
            }

            return (ArrayList<Prints>) sameTitles;
        }

        System.out.println("Prints not found!!!");

        return null;
    }

}
