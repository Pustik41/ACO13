package HomeWork.week2.Library.base;

import HomeWork.week2.Library.base.comp.ComparatorByTitle;

import java.util.ArrayList;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class Client {

    private String nameClient;
    private String surNameClient;

    private String numTelClient;
    private boolean inBlackList;
    private final int MAX_COUNT_PRINTS = 3;
    private ArrayList<Prints> clientPrints;

    public Client(String nameClient, String surNameClient, String numTelClient) {
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

    public String getNumTelClient() {
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

            if (!clientPrints.contains(print)) {
                return clientPrints.add(print);
            }

        return false;
    }

    public boolean delPrint(Prints print){

        return clientPrints.remove(print);
    }

    @Override
    public String toString() {

        return String.format("Client - %s %s, Tel: %s;", nameClient, surNameClient, numTelClient);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(obj.getClass() == this.getClass()) {

            Client tmp = (Client) obj;

            return this.nameClient.equals(tmp.nameClient) &&
                    this.surNameClient.equals(tmp.surNameClient) &&
                    this.numTelClient.equals(tmp.numTelClient);
        }

        return false;
    }
}
