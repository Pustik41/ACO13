package HomeWork.week2.Library.base;

import HomeWork.week2.Library.base.comp.ComparatorByNameClient;
import HomeWork.week2.Library.base.comp.ComparatorByTitle;
import HomeWork.week2.Library.base.comp.ComparatorByYear;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class Library {

    private String nameLibrary;
    private String numTelLib;

    private List<Prints> prints;
    private List<Client> clients;


    public Library(String nameLibrary, String numTelLib) {
        this.nameLibrary = nameLibrary;
        this.numTelLib = numTelLib;
        this.prints = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public boolean addPrints(Prints print){

        if(print == null){
            System.out.println("Prints not valid!!!");
            return false;
        }

        print = findPrint(print);

        if(!prints.contains(print)) {

            prints.add(print);
        }

        print.setAmount(1);
        return true;
    }

    public boolean addClient(Client client){

        if(client != null && clients.indexOf(client) < 0) {

            return clients.add(client);
        }

        return false;
    }

    public boolean addToBlackList(Client client){

        if(client != null && clients.contains(client)) {

            Client tmp = findClient(client);

//            if(tmp.getInBlackList() != true) {
//            keep it simple
            if(!tmp.getInBlackList()) {

                clients.get(clients.indexOf(client)).setInBlackList(true);

                return true;
            }
        }

        return false;
    }
//   do you delete all prints?
    public boolean delPrints(Prints print){

        if (print == null || !prints.contains(print)) return false;

        print = findPrint(print);

        if (print.getAmount() == 0) return false;

        print.setAmount(-1);
        return true;
    }

    public boolean delBlackList(Client client){

        if(client == null || !clients.contains(client)) return false;

        client = findClient(client);
//          KISS
        if(client.getInBlackList()) {
            client.setInBlackList(false);
            return true;
        }
        return false;
    }

    public boolean issuePrints(Client client, Prints print){

        if(client != null && clients.contains(client)){

            Client tmp = findClient(client);

            if (!tmp.getInBlackList()
                    && tmp.getClientPrints().size() < tmp.getMAX_COUNT_PRINTS() && delPrints(print)) {

                return tmp.addPrint(print);
            }
        }

        return false;
    }

    public boolean returnPrints(Client client, Prints print){

        if(client != null && print != null &&  clients.contains(client) && prints.contains(print)){

            client = findClient(client);
            print = findPrint(print);

            if(client.getClientPrints().contains(print) && addPrints(print)){
                return client.delPrint(print);
            }
        }
        return false;
    }

    public void showBlackList(){

        System.out.println("Black List:");

        clients.sort(new ComparatorByNameClient());

        for (Client cl: clients) {

            if(cl.getInBlackList()) System.out.println(cl);
        }
    }

    public void showClients(){

        System.out.println("Clients List:");

        clients.sort(new ComparatorByNameClient());

        for (Client cl: clients) {

            System.out.println(cl);
        }
    }

    public void showAvailablePrints(){

        System.out.println("Available Prints List:");

        prints.sort(new ComparatorByTitle());

        for (Prints pr: prints) {

            if(pr.getAmount() > 0) {
                System.out.println(pr + ", Amount - " + pr.getAmount() + ";");
            }
        }

    }

    public void showNeededPrints(){

        System.out.println("Needed Prints List:");

        prints.sort(new ComparatorByTitle());

        for (Prints pr: prints) {

            if(pr.getAmount() == 0) {
                System.out.println(pr + ", Amount - " + pr.getAmount() + ";");
            }
        }

    }

    public void showClientPrints(Client client){

        if(client != null  && clients.contains(client)) {

            if (client.getCountClientPtints() > 0) {

                System.out.println(client + "\nHave " + client.getClientPrints().size() + " prints:");

                for (Prints pr : client.getClientPrints()) {

                    System.out.println(pr);
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

            out.addAll(cl.getClientPrints());
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

        System.out.println("Was not issued any prints");
    }

    public void searchPrintsByAuthor(Author author){

        ArrayList<Prints> tmp = new ArrayList<>();

        for (Prints pr : prints) {

            if (author.equals(pr.getAuthor())) {
                tmp.add(pr);
            }
        }
//          DRY
        if(tmp.size() > 0) {

            tmp.sort(new ComparatorByTitle());

            for (Prints pr : tmp) {
                System.out.println(pr + ", Amount - " + pr.getAmount() + ";");
            }

            return;
        }

        System.out.println(author + " writer's book was not found");
    }

    public void searchPrintsByYear(int year){

        ArrayList<Prints> tmp = new ArrayList<>();

        for (Prints pr : prints) {

            if (year == pr.getYear()) {
                tmp.add(pr);
            }
        }
//          DRY
        if(tmp.size() > 0) {

            tmp.sort(new ComparatorByTitle());

            for (Prints pr : tmp) {
                System.out.println(pr + ", Amount - " + pr.getAmount() + ";");
            }

            return;
        }

        System.out.println("Prints of " + year + " was not found");
    }

    public List<Prints> searchPrints(String title){

        if(title != null){

            List<Prints> sameTitles = new ArrayList<>();

            prints.sort(new ComparatorByYear());

            for (Prints pr: prints) {
                if(pr.getTitle().equals(title)) {

                    System.out.println(pr + ", Amount - " + pr.getAmount() + ";");
                    sameTitles.add(pr);
                }
            }

            return sameTitles;
        }

        System.out.println("Prints not found!!!");

        return null;
    }
// bad name
//    private Prints findPrint(Prints print){
    private Prints findPrint(Prints print){

//        int haveCopy = prints.indexOf(print);
        int printIdx = prints.indexOf(print);

        if(printIdx >= 0){
            return prints.get(printIdx);
        }
// mayby better return null?
        return print;
    }
//bad name
    private Client findClient(Client client){

        int clientIdx = clients.indexOf(client);

        if( clientIdx >= 0){

            return clients.get(clientIdx);
        }
//      better return null
        return client;
    }
}
