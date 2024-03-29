package org.example;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Wallet {

    String owner;
    List<String> cards;
    HashMap<Integer, Integer> coins;
    HashMap<Integer, Integer> moneys;

    int[] coinsTypes = {100, 200, 500, 1000};
    int[] moneyTypes = {1000, 2000, 3000, 5000, 10000, 20000, 50000, 100000};

    public Wallet(String owner) {
        this.owner = owner;

        this.moneys = new HashMap<Integer, Integer>();
        for (int i = 0; i < moneyTypes.length; i++) {
            this.moneys.put(moneyTypes[i], 0);
        }

        this.coins = new HashMap<Integer, Integer>();
        for (int i = 0; i < coinsTypes.length; i++) {
            this.coins.put(coinsTypes[i], 0);
        }

        this.cards = new ArrayList<String>();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getCards() {
        return cards;
    }

    public void addCard(String card) {
        this.cards.add(card);
    }

    public void takeCard(String card) {
        this.cards.remove(card);
    }




    public HashMap<Integer, Integer> getMoneys() {
        return moneys;
    }
    public void addMoney(Integer moneyType) {
        boolean isMoneyValid = false;

        for (int i = 0; i < moneyTypes.length; i++) {
            if (moneyType == moneyTypes[i]) {
                isMoneyValid = true;
            }
        }

        if (isMoneyValid) {
            int initialValue = this.moneys.get(moneyType);
            this.moneys.put(moneyType, initialValue + 1);
        }
    }

    public HashMap<Integer, Integer> getCoins() {
        return coins;
    }
    public void addCoin(Integer coinType) {
        boolean isCoinValid = false;

        for (int i = 0; i < coinsTypes.length; i++) {
            if (coinType == coinsTypes[i]) {
                isCoinValid = true;
            }
        }

        if (isCoinValid) {
            int initialValue = this.coins.get(coinType);
            this.coins.put(coinType, initialValue + 1);
        }
    }

    public void takeCoins(Integer coinType) {
        int initialValue = this.coins.get(coinType);
        this.coins.put(coinType, initialValue - 1);
    }

    public void takeMoneys(Integer moneyType) {
        int initialValue = this.moneys.get(moneyType);
        this.moneys.put(moneyType, initialValue - 1);
    }

    public int getMoneyAvailable() {
        int total = this.calculateCoins() + this.calculateMoneys();
        return total;
    }

    public int calculateCoins() {
        int total = 0;
        for (Integer key : this.coins.keySet()) {
            total += key * this.coins.get(key);
        }
        return total;
    }

    public int calculateMoneys() {
        int total = 0;
        for (Integer key : this.moneys.keySet()){
            total += key * this.moneys.get(key);
        }
        return total;
    }

    public static  void main(String[] args){
        //contoh penggunaan kelas wallet
        Wallet myWallet = new Wallet("Jhon Doe");
        myWallet.addMoney(10000);
        myWallet.addMoney(5000);
        myWallet.addCoin(500);
        myWallet.addCard("Credit Card");
        myWallet.addCard("ATM");
        myWallet.takeCard("Credit Card");
        myWallet.takeCoins(500);
        myWallet.takeMoneys(10000);
        System.out.println("jumlah uang di dompet: " + myWallet.getMoneys());
        System.out.println("jumlah coins di dompet: " + myWallet.getCoins());
        System.out.println("kartu: " + myWallet.getCards());
        System.out.println("total uang di dompet: " + myWallet.getMoneyAvailable());
    }
}