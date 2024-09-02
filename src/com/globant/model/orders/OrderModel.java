package com.globant.model.orders;

import com.globant.model.CsvManager;

public class OrderModel {
    private final CsvManager csvManager = new CsvManager();

    public void setSellOrder(int orderId, int userid, String cryptoCurrencyName, double amount, double price){
        csvManager.writeSellOrder(orderId, userid, cryptoCurrencyName, amount, price);
    }

    public String[] getSellOrder(int userId, String currencyName, double amount, double price){
        return csvManager.getSellOrder(userId, currencyName, amount, price);
    }

    public void completeOrder(int userId, double newPrice){
        csvManager.updateSellerWallet(userId, newPrice);
    }
}
