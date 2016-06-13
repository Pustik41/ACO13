package HomeWork.week2.Library;

import HomeWork.week2.Library.comp.ComparatorByTitle;

import java.util.ArrayList;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class Client {

    private String nameClient;
    private String surNameClient;
//    todo better use String
    private long numTelClient;
    private boolean inBlackList;
    private final int MAX_COUNT_PRINTS = 3;
    private ArrayList<Prints> clientPrints;

    public Client(String nameClient, String surNameClient, long numTelClient) {
        this.nameClient = nameClient;
        this.surNameClient = surNameClient;
        this.numTelClient = numTelClient;
        this.clientPrints = new ArrayList<>(MAX_COUNT_PRINTS);
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

        clientPrints.sort(new ComparatorByTitle());
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

        if(clientPrints.size() < MAX_COUNT_PRINTS) {

            if (!clientPrints.contains(print)) {
                return clientPrints.add(print);
            }
        }

        System.out.println("Client have 3 prints!!!");

        return false;
    }
//    todo better boolean
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
// todo    equals() should check the class of its parameter
    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        Client tmp = (Client) obj;

        return this.nameClient.equals(tmp.nameClient) && this.surNameClient.equals(tmp.surNameClient) && this.numTelClient == tmp.numTelClient;
    }
}
