package com.globant.model.wallet;

import java.util.HashMap;

public class Wallet {
    private int userId;
    private double balanceFiat;
    private double bitCoinBalance;
    private double ethereumBalance;


    public Wallet(int userId, double balanceFiat) {
        this.userId = userId;
        this.balanceFiat = balanceFiat;
        this.bitCoinBalance = 0;
        this.ethereumBalance = 0;
    }

    public double getBalanceFiat() {
        return balanceFiat;
    }

    public void depositFiat(double amount) {
        balanceFiat = balanceFiat + amount;
    }
}
