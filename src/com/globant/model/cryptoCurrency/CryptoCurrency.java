package com.globant.model.cryptoCurrency;

import java.util.Random;

public class CryptoCurrency {

    private String shortHandSymbol;
    private int uniqueId;
    private double price;
    private String name;
    private Random rand  = new Random();

    public CryptoCurrency(String shortHandSymbol, double price, String name ) {
        uniqueId = rand.nextInt(Integer.MAX_VALUE) + 1;
        this.shortHandSymbol = shortHandSymbol;
        this.price = price;
        this.name = name;
    }


    public double getCryptoPrice(){
        return price;
    }

    public String getName(){
        return name;
    }


}
