package com.globant.model.wallet;

import java.util.HashMap;

public class Wallet {
    private int userId;
    private double balanceFiat;
    private HashMap<String, Double> cryptoCurrencies;


    public Wallet(int userId, double balanceFiat) {
        this.userId = userId;
        this.balanceFiat = balanceFiat;
        this.cryptoCurrencies = new HashMap<>();
    }

    public double getBalanceFiat() {
        return balanceFiat;
    }
}
