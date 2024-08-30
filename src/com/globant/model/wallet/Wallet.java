package com.globant.model.wallet;


public class Wallet {
    private final int userId;
    private double balanceFiat;
    private final double bitCoinBalance;
    private final double ethereumBalance;


    public Wallet(int userId, double balanceFiat) {
        this.userId = userId;
        this.balanceFiat = balanceFiat;
        this.bitCoinBalance = 0;
        this.ethereumBalance = 0;
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
}
