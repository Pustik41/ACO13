package HomeWork.week2.Library;

import HomeWork.week2.Library.comp.ComparatorByNameClient;
import HomeWork.week2.Library.comp.ComparatorByTitle;
import HomeWork.week2.Library.comp.ComparatorByYear;

import java.util.ArrayList;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class Library {

    private String nameLibrary;
    private long numTelLib;

    private ArrayList<Prints> prints;
    private ArrayList<Client> clients;
    private ArrayList<Client> blackList;
    private ArrayList<Author> authors;



    public Library(String nameLibrary, long numTelLib) {
        this.nameLibrary = nameLibrary;
        this.numTelLib = numTelLib;
        this.prints = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.blackList = new ArrayList<>();
        this.authors = new ArrayList<>();
    }

    public boolean addPrints(Prints print){

        if(print != null && !prints.contains(print)) {

            prints.add(print);

            if(!authors.contains(print.getAuthor())) authors.add(print.getAuthor());

            return true;
        }

        System.out.println("Prints can`t be added!!!");
        return false;
    }

    public boolean addClient(Client client){

        if(client != null && !clients.contains(client)) {

            clients.add(client);

            return true;
        }

        return false;
    }

    public boolean addBlackList(Client client){

        if(client != null && !blackList.contains(client)) {
            blackList.add(client);
            client.setInBlackList(true);

            return true;
        }

        return false;
    }

    public Prints delPrints(Prints print){

        if(prints.remove(print)){

            int counterAuthorPrints = 0;

            for (Prints pr: prints) {
                if(print.getAuthor().equals(pr.getAuthor())) counterAuthorPrints++;
            }

            if(counterAuthorPrints == 0) authors.remove(print.getAuthor());

            return print;
        }

        System.out.println("Prints not found");

        return null;
    }

    public boolean delBlackList(Client client){

        if(client != null && blackList.remove(client)) {

            client.setInBlackList(false);

            return true;
        }

        return false;
    }

    public boolean issuePrints(Client client, Prints print){

        if(client != null){

            if(client.getInBlackList() == true){
                System.out.println("Client in blackList!!!");
                return false;
            }

            if(delPrints(print) != null) {
                return client.addPrint(print);
            }
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

    public void showAuthorList(){

        System.out.println("Author List:");

        for (Author ar: authors) {
            System.out.println(ar);
        }
    }

    public void showBlackList(){

        System.out.println("Black List:");

        blackList.sort(new ComparatorByNameClient());

        for (Client cl: blackList) {

            System.out.println(cl.toString());
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

        for (Prints pr: prints) { System.out.println(pr);}

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

            for (Prints pr: out) {

                System.out.println(pr);
            }

            return;
        }

        System.out.println("Was mot issued any prints");
    }

    public void showPrintsByAuthor(Author author){

        ArrayList<Prints> tmp = new ArrayList<>();

        for (Prints pr : prints) {

            if (author.equals(pr.getAuthor())) {
                tmp.add(pr);
            }
        }

        if(tmp.size() > 0) {

            tmp.sort(new ComparatorByTitle());

            for (Prints pr : tmp) {
                System.out.println(pr);
            }

            return;
        }

        System.out.println(author.toString() + " writer's book was not found");
    }

    public void showPrintsByYear(int year){

        ArrayList<Prints> tmp = new ArrayList<>();

        for (Prints pr : prints) {

            if (year == pr.getYear()) {
                tmp.add(pr);
            }
        }

        if(tmp.size() > 0) {

            tmp.sort(new ComparatorByTitle());

            for (Prints pr : tmp) {
                System.out.println(pr);
            }

            return;
        }

        System.out.println("Prints of " + year + " was not found");
    }

    public Prints searchPrints(String title){

        if(title != null){

            for (Prints pr: prints) {

                if(title.equals(pr.getTitle())) return pr;
            }
        }

        System.out.println("Prints not found!!!");

        return null;
    }

}
