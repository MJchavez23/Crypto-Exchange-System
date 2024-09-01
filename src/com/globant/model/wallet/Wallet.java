package com.globant.model.wallet;


import com.globant.model.cryptoCurrency.Ethereum;

public class Wallet {
    private final int userId;
    private double balanceFiat;
    private double bitCoinBalance;
    private double ethereumBalance;


    public Wallet(int userId, double balanceFiat) {
        this.userId = userId;
        this.balanceFiat = balanceFiat;
        this.bitCoinBalance = 0;
        this.ethereumBalance = 0;
    }
    public void setBitCoinBalance(double newBitCoinBalance) {
        bitCoinBalance = bitCoinBalance + newBitCoinBalance;
    }

    public void setEthereumBalance(double newBitCoinBalance) {
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
}
