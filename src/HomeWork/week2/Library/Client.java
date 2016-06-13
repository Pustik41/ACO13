package HomeWork.week2.Library;

import java.util.ArrayList;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class Client {

    private String nameClient;
    private String surNameClient;
    private long numTelClient;
    private boolean inBlackList;
    private final int MAX_COUNT_PRINTS = 3;
    private ArrayList<Prints> clientPrints;

    public Client(String nameClient, String surNameClient, long numTelClient) {
        this.nameClient = nameClient;
        this.surNameClient = surNameClient;
        this.numTelClient = numTelClient;
        this.clientPrints = new ArrayList<>();
    }

    public String getNameClient() {
        return nameClient;
    }

    public String getSurNameClient() {
        return surNameClient;
    }

    public long getNumTelClient() {
        return numTelClient;
    }

    public int getMAX_COUNT_PRINTS() {
        return MAX_COUNT_PRINTS;
    }

    public ArrayList<Prints> getClientPrints() {
        return clientPrints;
    }

    public boolean getInBlackList() {
        return inBlackList;
    }

    public int getCountClientPtints(){
        return clientPrints.size();
    }

    public void setInBlackList(boolean inBlackList) {
        this.inBlackList = inBlackList;
    }

    public boolean addPrint(Prints print){

        if(clientPrints.size() + 1 <= MAX_COUNT_PRINTS) {

            if (!clientPrints.contains(print)) {
                clientPrints.add(print);
                return true;
            }
        }

        System.out.println("Client have 3 prints!!!");

        return false;
    }

    public Prints delPrint(Prints print){

        if (clientPrints.remove(print)) {
            return print;
        }

        return null;
    }

    @Override
    public String toString() {

        return String.format("Client - %s %s, Tel: %d;", nameClient, surNameClient, numTelClient);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        Client tmp = (Client) obj;

        return this.nameClient.equals(tmp.nameClient) && this.surNameClient.equals(tmp.surNameClient) && this.numTelClient == tmp.numTelClient;
    }
}
