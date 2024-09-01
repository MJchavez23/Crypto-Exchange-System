package com.globant.model.orders;

import com.globant.model.CsvManager;
import com.globant.model.transaction.TransactionModel;

public class OrderModel {
    private final TransactionModel transaction = new TransactionModel();
    private final CsvManager csvManager = new CsvManager();

    public void setSellOrder(int orderId, int userid, String cryptoCurrencyName, double amount, double price){
        csvManager.writeSellOrder(orderId, userid, cryptoCurrencyName, amount, price);
    }
}
