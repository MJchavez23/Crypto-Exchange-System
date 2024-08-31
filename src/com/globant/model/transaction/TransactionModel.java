package com.globant.model.transaction;


import com.globant.model.CsvManager;

public class TransactionModel {
    private int buyerId;
    private int sellerId;
    private String cryptoCurrencyName;
    private double amount;
    private double tradePrice;

    private final CsvManager csvManager = new CsvManager();

    public void placeTransaction(){
        csvManager.writeTransaction();
    }
}
