package HomeWork.week2.Library.base;

import HomeWork.week2.Library.base.comp.ComparatorByNameClient;
import HomeWork.week2.Library.base.comp.ComparatorByTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class Library {

    private String nameLibrary;
    private String numTelLib;

    private List<Prints> prints;
    private List<Client> clients;

    public Library() {
        this.nameLibrary = "";
        this.numTelLib = "";
        this.prints = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public Library(String nameLibrary, String numTelLib) {
        this.nameLibrary = nameLibrary;
        this.numTelLib = numTelLib;
        this.prints = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public boolean addPrint(Prints print){

        if(print == null) {return false;}

        Prints copyPrint = findPrint(print);

        if(copyPrint == null) {

            prints.add(print);
            print.setAmount(1);
            return true;
        }

        copyPrint.setAmount(1);

        return true;
    }

    public boolean addClient(Client client) {

        return clients.indexOf(client) < 0 && clients.add(client);
    }

    public boolean addToBlackList(Client client){

        Client findClient = findClient(client);

        if(findClient != null && !findClient.getInBlackList()) {
            findClient.setInBlackList(true);
            return true;
        }

        return false;
    }

    public boolean removePrint(Prints print){

        print = findPrint(print);

        if (print != null ) {

            if (print.getAmount() != 0) {
                print.setAmount(-1);
                return true;
            }
        }

        return false;
    }


    public boolean removeAllPrintCopies(Prints print){

        print = findPrint(print);
        if (print == null ) return false;

        print.setAmount(0);
        prints.remove(print);

        return true;
    }

    public void clearLibrariesPrints(){

        prints.clear();
    }

    public void clearLibraryOfClients(){

        clients.clear();
    }

    public boolean removeFromBlacklist(Client client){

        Client clientFromList = findClient(client);

        if(clientFromList == null || !clientFromList.getInBlackList()) return false;

        clientFromList.setInBlackList(false);

        return true;
    }

    public boolean issuePrints(Client client, Prints print){

        client = findClient(client);

        if(client != null){

            if (!client.getInBlackList()
                    && client.getClientPrints().size() < client.getMAX_COUNT_PRINTS() && removePrint(print)) {

                return client.addPrint(print);
            }
        }

        return false;
    }

    public boolean returnPrints(Client client, Prints print){

        client = findClient(client);
        print = findPrint(print);

        if(client != null && print != null){

            if(client.getClientPrints().contains(print) && addPrint(print)){
                return client.delPrint(print);
            }
        }
        return false;
    }

    public List<Client> showBlackList(){

        List<Client> blackList = new ArrayList<>();

        clients.sort(ComparatorByNameClient.getSort());

        for (Client cl: clients) {

            if(cl.getInBlackList()){
                blackList.add(cl);
            }
        }

        return blackList;
    }

    public List<Client> showClients(){

        clients.sort(ComparatorByNameClient.getSort());

        return clients;
    }

    public List<Prints> showAvailablePrints(){

        List<Prints> available = new ArrayList<>();

        for (Prints pr: prints) {

            if(pr.getAmount() > 0) {
                available.add(pr);
            }
        }

        available.sort(ComparatorByTitle.getSort());
        return available;
    }

    public List<Prints> showNeededPrints(){

        List<Prints> needed = new ArrayList<>();

        for (Prints pr: prints) {

            if(pr.getAmount() == 0) {
                needed.add(pr);
            }
        }

        needed.sort(ComparatorByTitle.getSort());
        return needed;
    }

    public List<Prints> showClientPrints(Client client){

        Client findClient = findClient(client);
        if(findClient == null || findClient.getClientPrints().size() == 0) return null;
        return  findClient.getClientPrints();
    }


    public List<Prints> showPrintsInOut(){

        List<Prints> out = new ArrayList<>();

        for (Client cl: clients) {
            out.addAll(cl.getClientPrints());
        }

        return out;
    }

    public List<Prints> searchPrintsByAuthor(Author author){

        List<Prints> authorPrints = new ArrayList<>();

        for (Prints pr : prints) {
            if (author.equals(pr.getAuthor())) {
                authorPrints.add(pr);
            }
        }

        authorPrints.sort(ComparatorByTitle.getSort());

        return authorPrints.size() > 0 ? authorPrints : null;
    }

    public List<Prints> searchPrintsByYear(int year){

        List<Prints> printsByYear = new ArrayList<>();

        for (Prints pr : prints) {
            if (year == pr.getYear()) {
                printsByYear.add(pr);
            }
        }

        printsByYear.sort(ComparatorByTitle.getSort());

        return printsByYear.size() > 0 ? printsByYear : null;
    }

    public List<Prints> searchPrintsByTitle(String title){

        if(title == null) return null;

        List<Prints> sameTitles = new ArrayList<>();

        for (Prints pr: prints) {

            if(pr.getTitle().contains(title)) {
                sameTitles.add(pr);
            }
        }

        sameTitles.sort(ComparatorByTitle.getSort());

        return sameTitles.size() > 0 ? sameTitles : null;
    }

    public Prints searchPrint(Prints print){

        if(print != null) return binarySearch(prints, print);

        return null;
    }

    private Prints findPrint(Prints print){

        int printIdx = prints.indexOf(print);

        return printIdx >= 0 ? prints.get(printIdx) : null;
    }

    private Client findClient(Client client){

        int clientIdx = clients.indexOf(client);

        return clientIdx >= 0 ? clients.get(clientIdx) : null;
    }

    private static<T extends Comparable<T>> T binarySearch(List<T> list, T object) {

        int start = 0;
        int end = list.size() - 1;

        if(object.equals(list.get(start))) return list.get(start);
        if(object.equals(list.get(end))) return list.get(end);

        while (start != end){

            int middle = start + (end - start) / 2;

            if (list.get(middle).compareTo(object) < 0){
                start = middle + 1;
            }
            else if (list.get(middle).compareTo(object) > 0){
                end = middle - 1;
            } else {
                return list.get(middle);
            }
        }

        return null;
    }

}
