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

    public boolean addPrint(Prints print){

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

    public boolean addClient(Client client) {

//        return client != null && clients.indexOf(client) < 0 && clients.add(client);
//        if you don't have nulls in clients list you can don't check on null (see indexOf)
        return clients.indexOf(client) < 0 && clients.add(client);

    }

    public boolean addToBlackList(Client client){

        Client findClient = findClient(client);

        if(findClient != null && findClient.getInBlackList()) {
            findClient.setInBlackList(true);
            return true;
        }

        return false;
    }

    public boolean removePrint(Prints print){

        if (print == null || !prints.contains(print)) return false;

        print = findPrint(print);

        if (print.getAmount() == 0) return false;

        print.setAmount(-1);
        return true;
    }

//        bad name
public Prints removeAllPrintAmount(Prints print){

        if (print == null || !prints.contains(print)) return null;

        print = findPrint(print);

        print.setAmount(0);
        prints.remove(print);

//        don't return print cause its the same print that you give in method arguments
        return print;
    }

    public void clearLibrariesPrints(){

        prints.clear();

    }

    public void clearLibraryOfClients(){

        clients.clear();
    }

    public boolean removeFromBlacklist(Client client){
//      find and contains do same job
//        if(client == null) return false;

        Client clientFromList = findClient(client);

        if(clientFromList == null || !clientFromList.getInBlackList()) return false;

        clientFromList.setInBlackList(false);

        return true;
    }

    public boolean issuePrints(Client client, Prints print){

        if(client != null && clients.contains(client)){

            Client tmp = findClient(client);
//        can be nullPointerEx
            if (!tmp.getInBlackList()
                    && tmp.getClientPrints().size() < tmp.getMAX_COUNT_PRINTS() && removePrint(print)) {

                return tmp.addPrint(print);
            }
        }

        return false;
    }

    public boolean returnPrints(Client client, Prints print){
//      find and contains do same job
        if(client != null && print != null &&  clients.contains(client) && prints.contains(print)){

            client = findClient(client);
            print = findPrint(print);
//        can be nullPointerEx

            if(client.getClientPrints().contains(print) && addPrint(print)){
                return client.delPrint(print);
            }
        }
        return false;
    }

    public List<Client> showBlackList(){

//  print logic must be in another class
//        System.out.println("Black List:");
        List<Client> blackList = new ArrayList<>();

        clients.sort(new ComparatorByNameClient());

        for (Client cl: clients) {

            if(cl.getInBlackList()){

                blackList.add(cl);
                System.out.println(cl);
            }
        }

        return blackList;
    }

    public List<Client> showClients(){
//  print logic must be in another class
//        System.out.println("Clients List:");

        clients.sort(new ComparatorByNameClient());

        for (Client cl: clients) {

            System.out.println(cl);
        }

        return clients;
    }

    public List<Prints> showAvailablePrints(){
//  print logic must be in another class
//        System.out.println("Available Prints List:");

        List<Prints> available = new ArrayList<>();

//        prints.sort(new ComparatorByTitle());

        for (Prints pr: prints) {

            if(pr.getAmount() > 0) {
                available.add(pr);
//                System.out.println(pr + ", Amount - " + pr.getAmount() + ";");
            }
        }
//        todo make comparators singleton
        available.sort(ComparatorByTitle.getInstance());
        return available;
    }

    public List<Prints> showNeededPrints(){

//        System.out.println("Needed Prints List:");

        List<Prints> needed = new ArrayList<>();

//        prints.sort(new ComparatorByTitle());

        for (Prints pr: prints) {

            if(pr.getAmount() == 0) {
                needed.add(pr);
//                System.out.println(pr + ", Amount - " + pr.getAmount() + ";");
            }
        }
        needed.sort(ComparatorByTitle.getInstance());
        return needed;
    }

    public List<Prints> showClientPrints(Client client){

        Client findClient = findClient(client);
        if(findClient == null || findClient.getClientPrints().size() == 0) return null;
        return  findClient.getClientPrints();
    }
    /*public List<Prints> showClientPrints(Client client){

        if(client != null  && clients.contains(client)) {

            if (client.getCountClientPtints() > 0) {

                System.out.println(client + "\nHave " + client.getClientPrints().size() + " prints:");

                for (Prints pr : client.getClientPrints()) {

                    System.out.println(pr);
                }

                return client.getClientPrints();
            }

            System.out.println(client.toString() + "\nDon`t have any prints");
        }

        return null;
    }*/
//  todo refactoring
    public List<Prints> showPrintsInOut(){

        List<Prints> out = new ArrayList<>();

        System.out.println("Issued books:");

        for (Client cl: clients) {

            out.addAll(cl.getClientPrints());
        }

        if(out.size() > 0){

            out.sort(ComparatorByTitle.getInstance());

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

            return out;
        }

        System.out.println("Was not issued any prints");

        return null;
    }

    public List<Prints> searchPrintsByAuthor(Author author){

        List<Prints> authorPrints = new ArrayList<>();

        for (Prints pr : prints) {
            if (author.equals(pr.getAuthor())) {
                authorPrints.add(pr);
            }
        }
        authorPrints.sort(ComparatorByTitle.getInstance());

        return authorPrints.size() > 0 ? authorPrints : null;
    }/*
    public List<Prints> searchPrintsByAuthor(Author author){

        List<Prints> tmp = new ArrayList<>();

        for (Prints pr : prints) {

            if (author.equals(pr.getAuthor())) {
                tmp.add(pr);
            }
        }

        if(tmp.size() > 0) {

            sortByTitleAndShow(tmp);

            return tmp;
        }

        System.out.println(author + " writer's book was not found");

        return null;
    }*/

    public List<Prints> searchPrintsByYear(int year){

        List<Prints> printsByYear = new ArrayList<>();

        for (Prints pr : prints) {
            if (year == pr.getYear()) {
                printsByYear.add(pr);
            }
        }
        printsByYear.sort(ComparatorByTitle.getInstance());
        return printsByYear.size() > 0 ? printsByYear : null;
    }/*
    public List<Prints> searchPrintsByYear(int year){

        List<Prints> tmp = new ArrayList<>();

        for (Prints pr : prints) {

            if (year == pr.getYear()) {
                tmp.add(pr);
            }
        }

        if(tmp.size() > 0) {

            sortByTitleAndShow(tmp);

            return tmp;
        }

        System.out.println("Prints of " + year + " was not found");

        return null;
    }*/

    public List<Prints> searchPrints(String title){

        if(title == null) return null;

        List<Prints> sameTitles = new ArrayList<>();

        for (Prints pr: prints) {
//            i think better use contains
            if(pr.getTitle().contains(title)) {
                sameTitles.add(pr);
            }
        }
        sameTitles.sort(new ComparatorByYear());

        return sameTitles.size() > 0 ? sameTitles : null;
    }/*  public List<Prints> searchPrints(String title){

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
    }*/

    private Prints findPrint(Prints print){

        int printIdx = prints.indexOf(print);

        if(printIdx >= 0){
            return prints.get(printIdx);
        }
// needed return print for addPrints
//        todo make another logic in addPrint
        return print;
    }

    private Client findClient(Client client){

        int clientIdx = clients.indexOf(client);

        return clientIdx >= 0 ? clients.get(clientIdx) : null;
    }

}
