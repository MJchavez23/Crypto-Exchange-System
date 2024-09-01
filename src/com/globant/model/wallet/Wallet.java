package com.globant.model.wallet;


public class Wallet {
    private final int userId;
    private double balanceFiat;
    private double bitCoinBalance;
    private double ethereumBalance;


    public Wallet(int userId, double balanceFiat, double bitCoinBalance, double ethereumBalance) {
        this.userId = userId;
        this.balanceFiat = balanceFiat;
        this.bitCoinBalance = bitCoinBalance;
        this.ethereumBalance = ethereumBalance;
    }
    public void addBitCoinBalance(double newBitCoinBalance) {
        bitCoinBalance = bitCoinBalance + newBitCoinBalance;
    }

    public void addEthereumBalance(double newBitCoinBalance) {
        ethereumBalance = ethereumBalance + newBitCoinBalance;
    }

    public double getBitCoinBalance(){
        return bitCoinBalance;
    }

    public double getEthereumBalance(){
        return ethereumBalance;
    }

    public double getBalanceFiat() {
        return balanceFiat;
    }

    public void depositFiat(double amount) {
        balanceFiat = balanceFiat + amount;
    }

    public void deductFiat(double amount) {
        balanceFiat = balanceFiat - amount;
    }

    public void deductEthereum(double amount) {
        ethereumBalance = ethereumBalance - amount;
    }

    public void deductBitcoin(double amount) {
        bitCoinBalance = bitCoinBalance - amount;
    }
}
