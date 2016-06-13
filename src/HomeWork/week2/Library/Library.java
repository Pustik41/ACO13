package HomeWork.week2.Library;

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

        for (Client cl: blackList) {

            System.out.println(cl.toString());
        }
    }

    public void showClients(){

        System.out.println("Clients List:");

        for (Client cl: clients) {

            System.out.println(cl);
        }
    }

    public void showPrints(){

        System.out.println("Prints List:");

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

        System.out.println("Issued books:");

        for (Client cl: clients) {

            for (Prints pr: cl.getClientPrints()) {

                System.out.println(pr.toString());
            }
        }
    }

    public void showPrintsByAuthor(Author author){

        int countFind = 0;

        for (Prints pr : prints) {

            if (author.equals(pr.getAuthor())) {
                System.out.println(pr);
                countFind++;
            }
        }

        if(countFind == 0) { System.out.println(author.toString() + " writer's book was not found");}
    }

    public void showPrintsByYear(int year){

        int countFind = 0;

        for (Prints pr : prints) {

            if (year == pr.getYear()) {
                System.out.println(pr);
                countFind++;
            }
        }

        if(countFind == 0) { System.out.println("Prints of " + year + " was not found");}
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
